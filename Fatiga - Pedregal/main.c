#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *archSal;
    archSal=fopen("C:\\Users\\Audioslave\\Desktop\\Fatiga.txt","wt");
    fprintf(archSal,"1000 1000\n2 1\n999998\n");
    int a,b;
    for(a=1; a<999; a++)
    {
        for(b=1; b<1001; b++)
        {
            fprintf(archSal,"%d %d\n",b, a);
        }
    }

    for(b=1; b<1000; b++)
    {
        fprintf(archSal,"%d 999\n",b);
    }

    for(b=1; b<1000; b++)
    {
        fprintf(archSal,"%d 1000\n",b);
    }
    fclose(archSal);
    return 0;
}
