import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

/**
 * 
 * @author TuckerKA20
 * @version 12/11/18
 */
public class Turkey
{
	public static void main( String[] args )
	{
		Scanner scan = null;

		try
		{
			File f = new File( "./src/Map.txt" );
			scan = new Scanner( f );

			//method1( scan );
			method2( scan );
		}
		catch ( Exception e )
		{
			System.out.print( e );
		}
		finally
		{
			if ( scan != null )
			{
				scan.close();
			}
		}
	}

	//Print in alphabetical order
	public static void method1( Scanner scan )
	{
		Map<String, Integer> thnxFoods = new TreeMap<>();

		while ( scan.hasNext() )
		{
			String currentFood = scan.nextLine();
			if ( thnxFoods.containsKey( currentFood ) )
			{
				thnxFoods.put( currentFood ,
						thnxFoods.get( currentFood ) + 1 );
			}
			else
			{
				thnxFoods.put( currentFood , 1 );
			}
		}

		for ( String s : thnxFoods.keySet() )
		{
			System.out.printf( "%-25s %20s%n" , s , thnxFoods.get( s ) );
		}
	}

	//Print least demanded to most demanded food
	public static void method2( Scanner scan )
	{
		Map<String, Integer> thnxFoods = new TreeMap<>();

		while ( scan.hasNext() )
		{
			String currentFood = scan.nextLine();
			if ( thnxFoods.containsKey( currentFood ) )
			{
				thnxFoods.put( currentFood ,
						thnxFoods.get( currentFood ) + 1 );
			}
			else
			{
				thnxFoods.put( currentFood , 1 );
			}
		}

		Map<Integer, TreeSet<String>> mostPop = new TreeMap<>();

		for ( String s : thnxFoods.keySet() )
		{
			Integer numTimes = thnxFoods.get( s );

			if ( mostPop.containsKey( numTimes ) )
			{
				mostPop.get( numTimes ).add( s );
			}
			else
			{
				TreeSet<String> t = new TreeSet<>();
				t.add( s );
				mostPop.put( numTimes , t );
			}
		}
		
		for ( Integer i : mostPop.keySet() )
		{
			System.out.printf( "%-2s %-5s%n" , i , mostPop.get( i ).toString() );
		}
	}
}
