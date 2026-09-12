package org.canureal;

public class Lexer {
    private final String source;
    private int position = 0;

    Lexer(String source) {
        this.source = source;
    }

    Token nextToken() {
        while (position < source.length() && Character.isWhitespace(source.charAt(position))) {
            position++;
        }

        if(position >= source.length()) {
            return new Token(TokenType.EOF, "");
        }

        char current = source.charAt(position);
        if (current == '(') {
            position++;
            return new Token(TokenType.LPAREN, "(");
        }
        if (current == ')') {
            position++;
            return new Token(TokenType.RPAREN, ")");
        }
        if (Character.isDigit(current)) {
            return number();
        }
        return symbol();
    }

    private Token number() {
        int start = position;

        while(position < source.length() && Character.isDigit(source.charAt(position))) {
            position++;
        }

        return new Token(
                TokenType.NUMBER,
                source.substring(start, position)
        );
    }

    private Token symbol() {
       int start = position;
       while (position < source.length()) {
           char current = source.charAt(position);

           if (Character.isWhitespace(current) || current == '(' || current == ')') {
               break;
           }

           position++;
       }

       return new Token(
               TokenType.SYMBOL,
               source.substring(start, position)
       );
    }
}
