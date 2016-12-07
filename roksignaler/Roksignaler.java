import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<String> code = new ArrayList<String>();
        String message = "";

        StringTokenizer string;
        
        //Read al input
        int s, p, t, b, m, e = 0, n = 0;

        for (int i = 0; i < 26; i++) {
            string = new StringTokenizer(in.readLine());
            letters.add(string.nextToken());
            code.add(string.nextToken());
        }

        string = new StringTokenizer(in.readLine());
        s = Integer.parseInt(string.nextToken());
        p = Integer.parseInt(string.nextToken());

        string = new StringTokenizer(in.readLine());
        t = Integer.parseInt(string.nextToken());
        b = Integer.parseInt(string.nextToken());
        m = Integer.parseInt(string.nextToken());

        string = new StringTokenizer(in.readLine());
        int z = Integer.parseInt(string.nextToken());

        //Convert the code to char array
        char c[] = new char[z];
        c = string.nextToken().toCharArray();

        //Create a variable that holds the morse-code for the current letter
        String letter = "";
        
        //Create a variable which keeps track of the previous digit
        int last = 1;
        
        //Loop through the char array
        for (int i = 0; i < z; i++) {
            if (c[i] == '1') {
                if (last != 1) {
                    if (n == t) {
                        n = 0;
                        e = 0;
                    } else if (n == b) {
                        message += letters.get(code.indexOf(letter));
                        letter = "";
                    } else if (n == m) {
                        message += letters.get(code.indexOf(letter));
                        letter = "";
                        message += ' ';
                    }
                    
                    n = 0;
                }

                e++;
                
                last = 1;
            } else if (c[i] == '0') {
                if (last != 0) {
                    if (e == s) {
                        letter += '-';
                    } else if (e == p) {
                        letter += '.';
                    }
                    
                    e = 0;
                }
                
                n++;
                
                last = 0;
            }
        }
        
        //Make sure that the last letter is appended to the message too. 
        if (e == s) {
            letter += '-';
        } else if (e == p) {
            letter += '.';
        }
        
        message += letters.get(code.indexOf(letter));

        out.append(message);

        in.close();
        out.flush();
        out.close();
    }
}
