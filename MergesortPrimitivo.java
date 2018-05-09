import java.util.Arrays;



public class Mergeprimitivo
{
	public static void main(String[] args)
	{
		String[] a = {"d","h","a","s","t",};//funciona con  enteros > integer , string ...
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int izq, int der)
	{
		if( izq < der )
		{
			int center = (izq + der) / 2;
			mergeSort(a, tmp, izq, center);
			mergeSort(a, tmp, center + 1, der);
			merge(a, tmp, izq, center + 1, der);
		}
	}


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int izq, int der, int finder )
    {
        int izqEnd = der - 1;
        int k = izq;
        int num = finder - izq + 1;

        while(izq <= izqEnd && der <= finder)
            if(a[izq].compareTo(a[der]) <= 0)
                tmp[k++] = a[izq++];
            else
                tmp[k++] = a[der++];

        while(izq <= izqEnd)    // copiar el resto de la primera mitad
            
            tmp[k++] = a[izq++];

        while(der <= finder)  // copiar el resto de la  mitad erecha
            tmp[k++] = a[der++];

        // copiar temp denuevo
        for(int i = 0; i < num; i++, finder--)
            a[finder] = tmp[finder];
    }
 }
