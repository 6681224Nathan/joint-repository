#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>

/*
Group member
Pitchayut Boonpon 		6680741
Wunna Aung Hein 		6680715
Nathan Tanaboriboon 	6681224rm
Prin Chinpanuwat 		6680744

*/

#define BLOCK_SIZE 4096

int main(void){
    char block[BLOCK_SIZE];
    int in, out;
    off_t mid, copied = 0;
    ssize_t n_read;
    struct stat st;

    in = open("text.txt", O_RDONLY);
    if (in < 0) { perror("open input"); return 1; }

    out = open("text_with_hole.txt", O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);
    if (out < 0) { perror("open output"); return 1; }

    if (fstat(in, &st) < 0) { perror("fstat"); return 1; }
    mid = st.st_size / 2;  // middle of input file

    /* Copy first half (up to mid) */
    while (copied < mid && (n_read = read(in, block, (mid - copied) > BLOCK_SIZE ? BLOCK_SIZE : (size_t)(mid - copied))) > 0){
        ssize_t w = write(out, block, n_read);
        if (w < 0) { perror("write first half"); return 1; }
        copied += w;
    }
    if (n_read < 0) { perror("read first half"); return 1; }

    /* Insert a 16-byte HOLE (sparse gap) in the output */
    if (lseek(out, 16, SEEK_CUR) < 0) { perror("lseek hole"); return 1; }

    /* Copy the rest */
    while ((n_read = read(in, block, sizeof(block))) > 0){
        ssize_t w = write(out, block, n_read);
        if (w < 0) { perror("write second half"); return 1; }
    }
    if (n_read < 0) { perror("read second half"); return 1; }

    close(in);
    close(out);
    return 0;
}
