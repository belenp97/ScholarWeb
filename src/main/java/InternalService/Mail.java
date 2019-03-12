//package InternalService;
//
//public class Mail {
//		
//		private String from;
//		private String to;
//		private String subject;
//		private String body;
//		
//		
//		public Mail() {}
//		
//		public Mail(String from, String to, String subject, String body) {
//			this.from = from;
//			this.to = to;
//			this.subject = subject;
//			this.body = body;
//		}
//		
//		public String getFrom() { return from; }
//		
//		public String getTo() { return to; }
//		
//		public String getSubject() { return subject; }
//		
//		public String getBody() { return body; }
//		
//		public void setFrom(String from) { this.from = from; }
//		
//		public void setTo(String to) { this.to = to; }
//		
//		public void setSubject(String subject ) { this.subject = subject; }
//
//		public void setBody (String body) { this.body = body; }
//		
//		
//		@Override
//		public String toString() {
//			return "Email[\nFrom: " + from + "\nTo: " + to + "\nSubject: " + subject + "\nMessage:\n" + body +"\n]\n";
//		}
//		
//		public String [] getParametros() {
//			String [] parameters = {from,to,subject,body};
//			return parameters;
//		}
//}
