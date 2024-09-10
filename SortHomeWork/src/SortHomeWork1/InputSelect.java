//1443 : 삽입 정렬


/**

#include <stdio.h>
int a[10001];
int n, i, j, temp, key;
int main() {
    scanf("%d", &n);
    for (i = 1; i <= n; i++)
        scanf("%d", &a[i]);
    for (i=2; i<=n; i++)
    {
        key=a[i];
        
        	(정답)
         while (j >= 1 && a[j] > key) {
            a[j + 1] = a[j];	
             j--;
        }
        

        {
            a[j+1]=a[j];
        }
        a[j+1]=key;
    }

    for (i=1; i<=n; i++)
        printf("%d\n", a[i]);
    return 0;
}



















*/
package SortHomeWork1;



