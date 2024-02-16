import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Type in a sentence to compute your reading level according to the Coleman-Liau Index.");
        String text = in.nextLine();

        System.out.println("Your reading level is:");
        levelComputer(text);
    }
    public static void levelComputer(String text){
        double letters = letterCount(text);
        double words = wordCount(text);
        double sentences = sentenceCounter(text);

        double indexLevel = (0.0588 * ((letters/words) * 100)) - (0.296 * ((sentences/words) * 100)) - 15.8;

        //Ondex level  conversion to grade level
        if (indexLevel > 13.0)
            System.out.println("College");
        else if (indexLevel > 12.0)
            System.out.println("Twelfth Grade");
        else if (indexLevel > 11.0)
            System.out.println("Eleventh Grade");
        else if (indexLevel > 10.0)
            System.out.println("Tenth Grade");
        else if (indexLevel > 9.0)
            System.out.println("Ninth Grade");
        else if (indexLevel > 8.0)
            System.out.println("Eight Grade");
        else if (indexLevel > 7.0)
            System.out.println("Seventh Grade");
        else if (indexLevel > 6.0)
            System.out.println("Sixth Grade");
        else if (indexLevel > 5.0)
            System.out.println("Fifth Grade");
        else if (indexLevel > 4.0)
            System.out.println("Fourth Grade");
        else if (indexLevel > 3.0)
            System.out.println("Third Grade");
        else if (indexLevel > 2.0)
            System.out.println("Second Grade");
        else if (indexLevel > 1.0)
            System.out.println("First Grade");
        else
            System.out.println("Kindergarten");
    }

    public static int sentenceCounter(String text){
        int count = 0;
        int sentence = 0;
        char [] senPunctuation = {'.', '?' , '!'};

        //Counts the number of non-blank characters in the string
        while (count < text.length()){
            for(int i = 0; i < senPunctuation.length; i++){
                if(text.charAt(count) == senPunctuation[i]){
                    sentence++;
                }
            }
            count++;
        }
        return sentence;
    }

    public static int wordCount(String text){
        //Splits the string into words using blank splace as a delimiter
        String[] words = text.split(" ");
        return words.length;
    }

    public static int letterCount(String text){
        int count = 0;
        int character = 0;
        char [] punctuation = {'.' , ',' , ';' , ':', '?' , '!' , '"' , '\'' , ')' , '('};

        //Counts the number of non-blank characters in the string
        while (count < text.length()){
            boolean isPunc = true;
            if(!(text.substring(count, count+1).isBlank())){
                for(int i = 0; i < punctuation.length; i++){
                    if (text.charAt(count) == punctuation[i]){
                        isPunc = false;
                        break;
                    }
                }
                if(isPunc){
                    character++;
                }
            }
            count++;
        }
        return character;
    }
}

/*
 * Type in a sentence to compute your reading level according to the Coleman-Liau Index.
Congratulations! Today is your day. You're off to Great Places! You're off and away!
Your reading level is:
Third Grade
 */