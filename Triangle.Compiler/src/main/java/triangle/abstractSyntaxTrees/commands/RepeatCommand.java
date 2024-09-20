package triangle.abstractSyntaxTrees.commands;

import triangle.abstractSyntaxTrees.commands.Command;
import triangle.abstractSyntaxTrees.expressions.Expression;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public class RepeatCommand extends Command {

    public RepeatCommand(Expression eAST, Command cAST, SourcePosition position) {
        super(position);
        E = eAST;
        C = cAST;
    }

    public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> v, Object arg) {
        return v.visitRepeatCommand(this, (TArg) arg);
    }

    public Expression E;
    public final Command C;
}