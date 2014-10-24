package terms;

import main.Problem;

public class ProtectionCondition extends LogicalAtom{
	
	public ProtectionCondition(String name){
		super(name);
	}
	
	public ProtectionCondition(ProtectionCondition clone){
		super(clone);
	}
	
	public ProtectionCondition(LogicalAtom la){
		super(la);
	}

	@Override
	public void addToWorld() {
		Problem.addProtection(this);
	}
	
	@Override
	public void delFromWorld() {
		Problem.delProtection(this);
	}
	
	public ProtectionCondition clone(){
		return new ProtectionCondition(this);
	}
}
