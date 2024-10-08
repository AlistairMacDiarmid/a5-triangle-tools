package triangle.optimiser;

import triangle.StdEnvironment;
import triangle.abstractSyntaxTrees.AbstractSyntaxTree;
import triangle.abstractSyntaxTrees.Program;
import triangle.abstractSyntaxTrees.actuals.*;
import triangle.abstractSyntaxTrees.aggregates.MultipleArrayAggregate;
import triangle.abstractSyntaxTrees.aggregates.MultipleRecordAggregate;
import triangle.abstractSyntaxTrees.aggregates.SingleArrayAggregate;
import triangle.abstractSyntaxTrees.aggregates.SingleRecordAggregate;
import triangle.abstractSyntaxTrees.commands.*;
import triangle.abstractSyntaxTrees.declarations.*;
import triangle.abstractSyntaxTrees.expressions.*;
import triangle.abstractSyntaxTrees.formals.*;
import triangle.abstractSyntaxTrees.terminals.CharacterLiteral;
import triangle.abstractSyntaxTrees.terminals.Identifier;
import triangle.abstractSyntaxTrees.terminals.IntegerLiteral;
import triangle.abstractSyntaxTrees.terminals.Operator;
import triangle.abstractSyntaxTrees.types.*;
import triangle.abstractSyntaxTrees.visitors.*;
import triangle.abstractSyntaxTrees.vnames.DotVname;
import triangle.abstractSyntaxTrees.vnames.SimpleVname;
import triangle.abstractSyntaxTrees.vnames.SubscriptVname;

public class ConstantFolder implements ActualParameterVisitor<Void, AbstractSyntaxTree>,
		ActualParameterSequenceVisitor<Void, AbstractSyntaxTree>, ArrayAggregateVisitor<Void, AbstractSyntaxTree>,
		CommandVisitor<Void, AbstractSyntaxTree>, DeclarationVisitor<Void, AbstractSyntaxTree>,
		ExpressionVisitor<Void, AbstractSyntaxTree>, FormalParameterSequenceVisitor<Void, AbstractSyntaxTree>,
		IdentifierVisitor<Void, AbstractSyntaxTree>, LiteralVisitor<Void, AbstractSyntaxTree>,
		OperatorVisitor<Void, AbstractSyntaxTree>, ProgramVisitor<Void, AbstractSyntaxTree>,
		RecordAggregateVisitor<Void, AbstractSyntaxTree>, TypeDenoterVisitor<Void, AbstractSyntaxTree>,
		VnameVisitor<Void, AbstractSyntaxTree> {
	{

	}

	@Override
	public AbstractSyntaxTree visitConstFormalParameter(ConstFormalParameter ast, Void arg) {
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitFuncFormalParameter(FuncFormalParameter ast, Void arg) {
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitProcFormalParameter(ProcFormalParameter ast, Void arg) {
		ast.I.visit(this);
		ast.FPS.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitVarFormalParameter(VarFormalParameter ast, Void arg) {
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Void arg) {
		ast.FT.visit(this);
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Void arg) {
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitDotVname(DotVname ast, Void arg) {
		ast.I.visit(this);
		ast.V.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSimpleVname(SimpleVname ast, Void arg) {
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSubscriptVname(SubscriptVname ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		ast.V.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitAnyTypeDenoter(AnyTypeDenoter ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitArrayTypeDenoter(ArrayTypeDenoter ast, Void arg) {
		ast.IL.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitBoolTypeDenoter(BoolTypeDenoter ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitCharTypeDenoter(CharTypeDenoter ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitErrorTypeDenoter(ErrorTypeDenoter ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSimpleTypeDenoter(SimpleTypeDenoter ast, Void arg) {
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitIntTypeDenoter(IntTypeDenoter ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitRecordTypeDenoter(RecordTypeDenoter ast, Void arg) {
		ast.FT.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitMultipleRecordAggregate(MultipleRecordAggregate ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		ast.I.visit(this);
		ast.RA.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSingleRecordAggregate(SingleRecordAggregate ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitProgram(Program ast, Void arg) {
		ast.C.visit(this, null);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitOperator(Operator ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitCharacterLiteral(CharacterLiteral ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitIntegerLiteral(IntegerLiteral ast, Void arg) {
		return ast;
	}

	@Override
	public AbstractSyntaxTree visitIdentifier(Identifier ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Void arg) {
		ast.FP.visit(this);
		ast.FPS.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Void arg) {
		ast.FP.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitArrayExpression(ArrayExpression ast, Void arg) {
		ast.AA.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitBinaryExpression(BinaryExpression ast, Void arg) {
		AbstractSyntaxTree replacement1 = ast.E1.visit(this);
		AbstractSyntaxTree replacement2 = ast.E2.visit(this);
		ast.O.visit(this);

		// if visiting a child node returns something, it's either the original constant
		// (IntegerLiteral) or a folded version replacing the expression at that child
		// node
		// If both child nodes are not null; return a folded version of this
		// BinaryExpression
		// Otherwise, at least one child node isn't constant (foldable) so just replace
		// the
		// foldable child nodes with their folded equivalent and return null
		if (replacement1 != null && replacement2 != null) {
			return foldBinaryExpression(replacement1, replacement2, ast.O);
		} else if (replacement1 != null) {
			ast.E1 = (Expression) replacement1;
		} else if (replacement2 != null) {
			ast.E2 = (Expression) replacement2;
		}

		// if we get here, we can't fold any higher than this level
		return null;
	}

	@Override
	public AbstractSyntaxTree visitCallExpression(CallExpression ast, Void arg) {
		ast.APS.visit(this);
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitCharacterExpression(CharacterExpression ast, Void arg) {
		ast.CL.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitEmptyExpression(EmptyExpression ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitIfExpression(IfExpression ast, Void arg) {
		AbstractSyntaxTree replacement1 = ast.E1.visit(this);
		if (replacement1 != null) {
			ast.E1 = (Expression) replacement1;
		}
		AbstractSyntaxTree replacement2 = ast.E2.visit(this);
		if (replacement2 != null) {
			ast.E2 = (Expression) replacement2;
		}
		AbstractSyntaxTree replacement3 = ast.E3.visit(this);
		if (replacement3 != null) {
			ast.E3 = (Expression) replacement3;
		}

		return null;
	}

	@Override
	public AbstractSyntaxTree visitIntegerExpression(IntegerExpression ast, Void arg) {
		return ast;
	}

	@Override
	public AbstractSyntaxTree visitLetExpression(LetExpression ast, Void arg) {
		ast.D.visit(this);
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

	@Override
	public AbstractSyntaxTree visitRecordExpression(RecordExpression ast, Void arg) {
		ast.RA.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitUnaryExpression(UnaryExpression ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}

		ast.O.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitVnameExpression(VnameExpression ast, Void arg) {
		ast.V.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Void arg) {
		ast.ARG1.visit(this);
		ast.ARG2.visit(this);
		ast.O.visit(this);
		ast.RES.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitConstDeclaration(ConstDeclaration ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitFuncDeclaration(FuncDeclaration ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		ast.FPS.visit(this);
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitProcDeclaration(ProcDeclaration ast, Void arg) {
		ast.C.visit(this, null);
		ast.FPS.visit(this);
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSequentialDeclaration(SequentialDeclaration ast, Void arg) {
		ast.D1.visit(this);
		ast.D2.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitTypeDeclaration(TypeDeclaration ast, Void arg) {
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Void arg) {
		ast.ARG.visit(this);
		ast.O.visit(this);
		ast.RES.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitVarDeclaration(VarDeclaration ast, Void arg) {
		ast.I.visit(this);
		ast.T.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitAssignCommand(AssignCommand ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		ast.V.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitCallCommand(CallCommand ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitEmptyCommand(EmptyCommand ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitIfCommand(IfCommand ast, Void arg) {
		ast.C1.visit(this, null);
		ast.C2.visit(this, null);
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

	@Override
	public AbstractSyntaxTree visitLetCommand(LetCommand ast, Void arg) {
		ast.C.visit(this, null);
		ast.D.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSequentialCommand(SequentialCommand ast, Void arg) {
		ast.C1.visit(this, null);
		ast.C2.visit(this, null);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitWhileCommand(WhileCommand ast, Void arg) {
		ast.C.visit(this, null);
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

//TODO uncomment if you've implemented the repeat command
	@Override
	public AbstractSyntaxTree visitRepeatCommand(RepeatCommand ast, Void arg) {
		ast.C.visit(this, null);
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

	@Override
	public AbstractSyntaxTree visitMultipleArrayAggregate(MultipleArrayAggregate ast, Void arg) {
		ast.AA.visit(this);
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSingleArrayAggregate(SingleArrayAggregate ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

	@Override
	public AbstractSyntaxTree visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Void arg) {
		return null;
	}

	@Override
	public AbstractSyntaxTree visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Void arg) {
		ast.AP.visit(this);
		ast.APS.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitSingleActualParameterSequence(SingleActualParameterSequence ast, Void arg) {
		ast.AP.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitConstActualParameter(ConstActualParameter ast, Void arg) {
		AbstractSyntaxTree replacement = ast.E.visit(this);
		if (replacement != null) {
			ast.E = (Expression) replacement;
		}
		return null;
	}

	@Override
	public AbstractSyntaxTree visitFuncActualParameter(FuncActualParameter ast, Void arg) {
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitProcActualParameter(ProcActualParameter ast, Void arg) {
		ast.I.visit(this);
		return null;
	}

	@Override
	public AbstractSyntaxTree visitVarActualParameter(VarActualParameter ast, Void arg) {
		ast.V.visit(this);
		return null;
	}

	public AbstractSyntaxTree foldBinaryExpression(AbstractSyntaxTree node1, AbstractSyntaxTree node2, Operator o) {
		// the only case we know how to deal with for now is two IntegerExpressions
		if ((node1 instanceof IntegerExpression) && (node2 instanceof IntegerExpression)) {
			int int1 = (Integer.parseInt(((IntegerExpression) node1).IL.spelling));
			int int2 = (Integer.parseInt(((IntegerExpression) node2).IL.spelling));
			Object foldedValue = null;
			
			if (o.decl == StdEnvironment.addDecl) {
				foldedValue = int1 + int2;
			}

			if (foldedValue instanceof Integer) {
				IntegerLiteral il = new IntegerLiteral(foldedValue.toString(), node1.getPosition());
				IntegerExpression ie = new IntegerExpression(il, node1.getPosition());
				ie.type = StdEnvironment.integerType;
				return ie;
			} else if (foldedValue instanceof Boolean) {
				/* currently not handled! */
			}
		}

		// any unhandled situation (i.e., not foldable) is ignored
		return null;
	}

}
