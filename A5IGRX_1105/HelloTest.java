package hu.A5IGRX.springbootweb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloTest {

	
	public String getIndex() {return "index";}
	@PostMapping
	public String index()
	{
		return "Hello Spring Boot web world!";
	}
	@PostMapping("/hello/{name}")
	public String A5IGRXhello(@PathVariable("name") String name)
	{
		return "üdv," +name +"!";
	}
	@PostMapping("/add")
	public String add(@RequestParam("a") int a,@RequestParam("b")int b)
	{
	return ""+a+"+"+b+"="+(a+b);	
	}
	@GetMapping
	public String GMindex()
	{
		return "Hello Spring Boot web world!";
	}
	@GetMapping("/hello/{name}")
	public String A5IGRXGMhello(@PathVariable("name") String name)
	{
		return "üdv," +name +"!";
	}
	@GetMapping("/add")
	public String GMadd(@RequestParam("a") int a,@RequestParam("b")int b)
	{
	return ""+a+"+"+b+"="+(a+b);	
	}
}
