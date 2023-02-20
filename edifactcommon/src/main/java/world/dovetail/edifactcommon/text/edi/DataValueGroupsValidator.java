package world.dovetail.edifactcommon.text.edi;

public class DataValueGroupsValidator extends DataValueValidator {
	protected DataValueValidator[] mValidators;
	
	public DataValueGroupsValidator(DataValueValidator[] validators) {
		mValidators = validators;
	}

	public boolean isIncomplete() {
		for( DataValueValidator validator: mValidators ) {
			if( validator.isIncomplete() )
				return true;
		}
		return false;
	}
	
	public boolean hasValue(String value) {
		for( DataValueValidator validator: mValidators ) {
			if( validator.hasValue(value) )
				return true;
		}
		return false;
	}

	public String getCodeListValues() {
		StringBuffer sb = new StringBuffer();
		for( int i = 0; i < mValidators.length; i++) {
			String s = mValidators[i].getCodeListValues();
			if( s.length() > 0 ) {
				if( sb.length() > 0 )
					sb.append( "; " );
				sb.append( s );
				}
		}
		return sb.toString();
	}
}
