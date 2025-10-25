#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <signal.h>
#include <errno.h>

#define FIFO1 "/tmp/fifo1to2"
#define FIFO2 "/tmp/fifo2to1"
#define MAX_BUF 256

/*
Pitchayut Boonporn 		6680741
Wunna Aung Hein 		6680715
Nathan Tanaboriboon 	6681224
Prin Chinpanuwat 		6680744
*/

int main(int argc, char* argv[])
{
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <1 or 2>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    // Create FIFOs if not exist
    mkfifo(FIFO1, 0666);
    mkfifo(FIFO2, 0666);

    int fd_send, fd_recv;
    pid_t child;
    char sbuf[MAX_BUF], rbuf[MAX_BUF];

    printf("Starting chat %s...\n", argv[1]);

    // Determine direction
    if (strcmp(argv[1], "1") == 0) {
        // Process 1 sends to FIFO1, receives from FIFO2
        // Wait for partner
        while ((fd_send = open(FIFO1, O_WRONLY)) == -1) {
            if (errno == ENXIO) {
                printf("Waiting for Process 2 to start...\n");
                sleep(1);
            } else {
                perror("open send");
                exit(EXIT_FAILURE);
            }
        }
        fd_recv = open(FIFO2, O_RDONLY);
    } 
    else if (strcmp(argv[1], "2") == 0) {
        // Process 2 sends to FIFO2, receives from FIFO1
        fd_recv = open(FIFO1, O_RDONLY);
        fd_send = open(FIFO2, O_WRONLY);
    } 
    else {
        fprintf(stderr, "Invalid argument. Use 1 or 2.\n");
        exit(EXIT_FAILURE);
    }

    if (fd_send < 0 || fd_recv < 0) {
        perror("open");
        exit(EXIT_FAILURE);
    }

    child = fork();
    if (child == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (child == 0) {
        // Receiver
        while (1) {
            memset(rbuf, 0, sizeof(rbuf));
            ssize_t n = read(fd_recv, rbuf, sizeof(rbuf));
            if (n > 0) {
                if (strncmp(rbuf, "end chat", 8) == 0) {
                    printf("\nFriend ended the chat.\n");
                    kill(getppid(), SIGTERM);
                    exit(0);
                }
                printf("\nFriend: %s\nYou: ", rbuf);
                fflush(stdout);
            }
        }
    } else {
        // Sender
        printf("You: ");
        fflush(stdout);
        while (1) {
            memset(sbuf, 0, sizeof(sbuf));
            fgets(sbuf, MAX_BUF, stdin);
            sbuf[strcspn(sbuf, "\n")] = '\0';
            write(fd_send, sbuf, strlen(sbuf) + 1);

            if (strncmp(sbuf, "end chat", 8) == 0) {
                kill(child, SIGTERM);
                break;
            }
            printf("You: ");
            fflush(stdout);
        }
    }

    close(fd_send);
    close(fd_recv);

    if (strcmp(argv[1], "1") == 0) {
        unlink(FIFO1);
        unlink(FIFO2);
    }

    return 0;
}
