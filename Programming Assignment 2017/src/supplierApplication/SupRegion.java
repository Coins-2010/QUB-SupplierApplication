package supplierApplication;

public enum SupRegion {
	UNITED_KINGDOM {
		@Override
		String regionAsString() {
			// TODO Auto-generated method stub
			return "United Kingdom";
		}
	}, EUROPE {
		@Override
		String regionAsString() {
			// TODO Auto-generated method stub
			return "Europe";
		}
	}, OUTSIDE_EU {
		@Override
		String regionAsString() {
			// TODO Auto-generated method stub
			return "Outside EU";
		}
	};
	
	abstract String regionAsString();
	

}
