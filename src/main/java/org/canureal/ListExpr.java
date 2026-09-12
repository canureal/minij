package org.canureal;

import java.util.List;

public record ListExpr(List<Expr> elements) implements Expr {
}
