package triangle.abstractSyntaxTrees.visitors;

import triangle.abstractSyntaxTrees.types.*;

public interface TypeDenoterVisitor<TArg, TResult> extends FieldTypeDenoterVisitor<TArg, TResult> {

	TResult visitAnyTypeDenoter(AnyTypeDenoter ast, TArg arg);

	TResult visitArrayTypeDenoter(ArrayTypeDenoter ast, TArg arg);

	TResult visitBoolTypeDenoter(BoolTypeDenoter ast, TArg arg);

	TResult visitCharTypeDenoter(CharTypeDenoter ast, TArg arg);

	TResult visitErrorTypeDenoter(ErrorTypeDenoter ast, TArg arg);

	TResult visitSimpleTypeDenoter(SimpleTypeDenoter ast, TArg arg);

	TResult visitIntTypeDenoter(IntTypeDenoter ast, TArg arg);

	TResult visitRecordTypeDenoter(RecordTypeDenoter ast, TArg arg);

}
