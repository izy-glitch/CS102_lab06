import java.io.File;

public class Lab06 {

    public static int lengthOfString( String str ){
        int count = 0;

        if ( str == "" ){
            return count;
        }
        else{
            count++;
            return lengthOfString( str.substring( 1 ) ) + 1 ;
        }
    }

    public static int countNonVowels( String str ){
        StringBuffer nonVowels = new StringBuffer( "qwrtypsdfghjklzxcvbnm");
        str.toLowerCase();
        if ( str == "" ){
            return 0;
        }
        else if ( nonVowels.indexOf( String.valueOf( str.charAt( 0 ) ) ) == -1 ){
            return countNonVowels( str.substring( 1 ) )  ;
        }
        else{
            return countNonVowels( str.substring( 1 ) ) + 1 ;
        }
    }

    public static void binaryStrings( int n, String output, int lastDigit ){
        if ( n == 0 ){
            System.out.println( output );
            return;
        }

        binaryStrings( n - 1, output + '0', 0 );

        if ( lastDigit == 0 ){
            binaryStrings( n - 1, output + '1', 1 );
        }
    }

    public static void fileCount( File[] file, int index, int lev ){
        int counter = 0;

        if( index == file.length ){
            System.out.println( counter );
            return;
        }
        for ( int i = 0; i < lev; i++ ){
            System.out.print("\t");

            if( file[index].isFile() ){
                counter++;
            }
            else if( file[index].isDirectory() ) {
                counter++;
                fileCount( file[index].listFiles(), 0, lev + 1 );
            }
        }
        fileCount( file, ++index, lev  );
    }
    public static void main( String[] args ) {
         String maindirpath = "/Users/ilaydazehrayilmaz/Desktop/CS 102";
         File maindir = new File( maindirpath );

         System.out.println( lengthOfString( "CS102 is the best" ) );
         System.out.println( countNonVowels( "CS102 is a good course" ) );
         binaryStrings( 3, "" , 0);

        if( maindir.exists() && maindir.isDirectory() ) {
            File file[] = maindir.listFiles();
            fileCount( file,0,0 );
        }

    }

}

