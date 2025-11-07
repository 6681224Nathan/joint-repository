#include <stdio.h>
#include <stdlib.h>
#define BLOCK_SIZE 512

/*
Pitchayut Boonpon 		6680741
Wunna Aung Hein 		6680715
Nathan Tanaboriboon 	6681224
Prin Chinpanuwat 		6680744


*/

int main(void)
{
    FILE *in, *out;
    char block[BLOCK_SIZE];

    // open files
    in = fopen("input.txt", "r");
    if (in == NULL) {
        perror("Error opening input file");
        return 1;
    }

    out = fopen("output.txt", "w");
    if (out == NULL) {
        perror("Error opening output file");
        fclose(in);
        return 1;
    }

    // copy line by line (up to 511 chars at a time)
    while (fgets(block, sizeof(block), in) != NULL) {
        if (fputs(block, out) == EOF) {
            perror("Error writing to output file");
            fclose(in);
            fclose(out);
            return 1;
        }
    }

    fclose(in);
    fclose(out);
    return 0;
}
