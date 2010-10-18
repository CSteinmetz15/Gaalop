package de.gaalop.gealg.output;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import de.gaalop.cfg.AssignmentNode;
import de.gaalop.cfg.BlockEndNode;

import de.gaalop.cfg.ControlFlowVisitor;
import de.gaalop.cfg.EndNode;

import de.gaalop.cfg.IfThenElseNode;

import de.gaalop.cfg.StartNode;
import de.gaalop.cfg.StoreResultNode;
import de.gaalop.dfg.*;
import de.gaalop.gealg.GealgBladeTable;
import de.gaalop.gealg.GealgMultiVector;
import de.gaalop.gealg.NameTable;

/**
 *  This Visitors job is it to traverse the ControlFlowGraph to find appearances of 
 *  a certain multi-vector (mv). If found the referred blade 'address' is added to a set.
 *  The Gealg/Galet plugin needs this information in order to define the right mv in the code.
 * 
 * @author Thomas Kanold
 *
 */
public class FieldsUsedVisitor implements ControlFlowVisitor, ExpressionVisitor{

	private GealgMultiVector multivector;

	public FieldsUsedVisitor(String name) {
		multivector = new GealgMultiVector(name);
	}

	public List<Integer> getBladeList(){
		List <Integer> result= new LinkedList<Integer>(multivector.getGaalopBlades().keySet());
		return result;
	}
	
	public GealgMultiVector getMultiVector(){
		return multivector;
	}
	private String printVarName(String key) {
		return NameTable.getInstance().get(key);
	}	
	public String giveDefinition() {
		
		int size = multivector.getGaalopBlades().size();
		
		String definition;		
		if ( size == 0) {
			definition = "double ";
			definition += printVarName(multivector.getName()) + ";";
		} else {
		    definition = "gaalet::cm::mv<";
			//definition += size;
			//definition += ", ";
			definition += createHexString();
			definition += ">::type " + printVarName(multivector.getName()) + ';';				
		}
		return definition;		
	}
	
	private String createHexString() {
		return multivector.getDefinition();
	}
//Expressions
	@Override
	public void visit(MultivectorComponent node) {
		String nameMV = multivector.getName().replace("_opt", "");
		String nameNode = node.getName().replace("_opt", "");
		if (nameMV.equals(nameNode) )
    		multivector.addComponent(node.getBladeIndex());		
	}	
	
	@Override
	public void visit(Subtraction node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);	
	}

	@Override
	public void visit(Addition node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);
	}

	@Override
	public void visit(Division node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);		
	}

	@Override
	public void visit(InnerProduct node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);		
	}

	@Override
	public void visit(Multiplication node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);		
	}

	@Override
	public void visit(MathFunctionCall node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Variable node) {
		// just do nothing, because only MulitvectorComponent is important		
	}

	@Override
	public void visit(FloatConstant node) {
		// just do nothing, because only MulitvectorComponent is important

	}

	@Override
	public void visit(OuterProduct node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);
	}

	@Override
	public void visit(BaseVector node) {
		// just do nothing, because only MulitvectorComponent is important
		
	}

	@Override
	public void visit(Negation node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getOperand().accept(this);
	}

	@Override
	public void visit(Reverse node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getOperand().accept(this);
	}

	@Override
	public void visit(LogicalOr node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);
	}

	@Override
	public void visit(LogicalAnd node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);		
	}

	@Override
	public void visit(Equality node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);		
	}

	@Override
	public void visit(Inequality node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);		
	}

	@Override
	public void visit(Relation relation) {
		// just do nothing, because only MulitvectorComponent is important
		relation.getLeft().accept(this);
		relation.getRight().accept(this);		
	}

// controlflow
	public void visit(Exponentiation node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getLeft().accept(this);
		node.getRight().accept(this);
	}	
	
	
	@Override
	public void visit(StartNode node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getSuccessor().accept(this);
	}

	@Override
	public void visit(AssignmentNode node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getValue().accept(this);
		node.getVariable().accept(this);
		node.getSuccessor().accept(this);
	}

	@Override
	public void visit(StoreResultNode node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getSuccessor().accept(this);
	}

	@Override
	public void visit(IfThenElseNode node) {
		// just do nothing, because only MulitvectorComponent is important
		node.getCondition().accept(this);
	    node.getPositive().accept(this);
	    node.getNegative().accept(this);
	    node.getSuccessor().accept(this);
	}

	@Override
	public void visit(BlockEndNode node) {
		// just do nothing, because only MulitvectorComponent is important
		//node.getSuccessor().accept(this);
	}

	@Override
	public void visit(EndNode node) {
		// just do nothing, because only MulitvectorComponent is important
	}



}
