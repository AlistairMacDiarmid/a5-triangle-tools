package triangle.abstractSyntaxTrees.visitors;

import triangle.abstractSyntaxTrees.declarations.*;
import triangle.abstractSyntaxTrees.types.TypeDeclaration;

public interface DeclarationVisitor<TArg, TResult> extends FormalParameterVisitor<TArg, TResult> {

	TResult visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, TArg arg);

	TResult visitConstDeclaration(ConstDeclaration ast, TArg arg);

	TResult visitFuncDeclaration(FuncDeclaration ast, TArg arg);

	TResult visitProcDeclaration(ProcDeclaration ast, TArg arg);

	TResult visitSequentialDeclaration(SequentialDeclaration ast, TArg arg);

	TResult visitTypeDeclaration(TypeDeclaration ast, TArg arg);

	TResult visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, TArg arg);

	TResult visitVarDeclaration(VarDeclaration ast, TArg arg);

}
