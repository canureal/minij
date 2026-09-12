package org.canureal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main  {
    public static void main() throws IOException {
        Path filepath = Path.of("src/main/java/org/canureal/main.mj");
        String mj_file = Files.readString(filepath);

        Lexer lexer = new Lexer(mj_file);

       Token token;

       do {
           token = lexer.nextToken();
           System.out.println(token.type + "-> " + token.value);
       } while (token.type != TokenType.EOF);
    }
}
