package com.mojeshhere;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
	public class MyController {
	
	@RequestMapping("/")
	public String votepage() {
		
		return "home";
		
	}		
		@RequestMapping("/req1")
		public String ItemNumber(@RequestParam int no,@RequestParam String name,
				@RequestParam double sal,ModelMap m) {
			m.put("k1",no);
			m.put("k2",name);
			m.put("k3",sal);
			double ta=0.0,da=0.0,hra=0.0,pf=0.0,gross_sal=0.0,net_sal=0.0;
			if(sal<3000) {
				ta=sal*7/100;
				da=sal*9/100;
				hra=sal*11/100;
				pf=sal*15/100;
			}
			else if(sal>=30000&&sal<5000) {
				ta=sal*10/100;
				da=sal*13/100;
				hra=sal*17/100;
				pf=sal*22/100;
			}
			else {
				ta=sal*17/100;
				da=sal*19/100;
				hra=sal*21/100;
				pf=sal*25/100;
			}
			gross_sal=ta+da+hra-sal;
			net_sal=gross_sal-pf;
			m.put("k4",ta);
			m.put("k5",da);
			m.put("k6",hra);
			m.put("k7",pf);
			m.put("k8",gross_sal);
			m.put("k9",net_sal);
			
		return "result";
		}
		
}



