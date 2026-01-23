import java.io.*;
class ReverseString {

    String reverse(String inputString) {
        StringBuilder res = new StringBuilder();
        res.append(inputString);
        return res.reverse().toString();
    }
}
