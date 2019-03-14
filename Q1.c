#include<stdio.h>
#include<stdlib.h>
#include<sys/wait.h>
#include<unistd.h>

int main(int x, char **y){
   int n;
  
   if(x==1){ 
		exit(0);
	}
  
	n = atoi(y[1]);
  
	if(n<= 0){
	   printf("\nInsert a positive integer.\n\n");
		exit(0);
	}
  
	if(fork() == 0){ 
	   while(n > 1){
		   printf("%d ", n);
		   if(n %2 == 0)
			   n = n / 2;
		   else
			   n = 3 * n + 1;      
	   }
	   printf("1\n\n");
	}
	else{ 
	   wait(NULL);
	}
  
	return 0;
}
