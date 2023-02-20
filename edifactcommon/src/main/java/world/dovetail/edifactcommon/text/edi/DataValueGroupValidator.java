package world.dovetail.edifactcommon.text.edi;

public class DataValueGroupValidator extends DataValueValidator {
	protected String mName;
	protected DataValueValidator[] mValidators;
	
	public DataValueGroupValidator(String name, DataValueValidator[] validators) {
		mName = name;
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
			if( !validator.hasValue(value) )
				return false;
			}
		return true;
	}

	public String getCodeListValues() {
		if( mName.length() > 0 )
			return "Values from code list " + mName;

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
