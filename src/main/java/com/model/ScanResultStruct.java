package com.model;

	public class ScanResultStruct {

		private String fileType;
		private String engineName;
		private String category;
		
		
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public String getEngineName() {
			return engineName;
		}
		public void setEngineName(String engineName) {
			this.engineName = engineName;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		@Override
		public String toString() {
			return "Engine: " + engineName + ", Verdict: " + category + "";
		}
		
	}

