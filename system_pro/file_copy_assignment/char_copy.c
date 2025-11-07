#include <stdio.h>
#include <stdlib.h>

/*
Pitchayut Boonpon 		6680741
Wunna Aung Hein 		6680715
Nathan Tanaboriboon 	6681224
Prin Chinpanuwat 		6680744


*/

int main(void){
    // Declare Variables and Pointers
    int c;
    FILE *in_file, *out_file;

    // Open the files
    in_file = fopen("input.txt", "r");
    out_file = fopen("output.txt", "w");

    // Check for errors
    if (in_file == NULL || out_file == NULL){
        perror("Errors openning files");
        exit(EXIT_FAILURE);
    }

    // Copy the files
    while ((c = getc(in_file)) != EOF){
        putc(c, out_file);
    }

    // Close the files
    fclose(in_file);
    fclose(out_file);

    return 0;
}
