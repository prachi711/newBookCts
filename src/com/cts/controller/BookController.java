package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Dao.BookDao;
import com.cts.Entity.Book;

import com.cts.service.BookService;
import com.cts.service.UserService;

@Controller
public class BookController {

	
	
	@Autowired
	  public BookService bookService;
	 @Autowired
	  public UserService userService;
	 @Autowired 
	public BookDao bookDao;
	
	  
	 @RequestMapping(value = "/addBook", method = RequestMethod.GET)
	  public ModelAndView showBooks() {
	    ModelAndView mav = new ModelAndView("addBook");
	    mav.addObject("book", new Book());
	  
		
	    return mav;
	  }
	  
	  @RequestMapping(value = "/addBook", method = RequestMethod.POST)
	  public ModelAndView addBook(@ModelAttribute("book") Book book) throws Exception {
	  bookService.save(book);
	
	return new ModelAndView("redirect:/viewBook");
	  }
	  
	    @RequestMapping("/viewBook")    
	    public String viewBook(Model m){    
	        List<Book> list=bookDao.getBook();    
	        m.addAttribute("list",list); 
	    
			
	        return "viewBook";  
	        
	    }    
	  
	    @RequestMapping(value="/deleteBook/{bookcode}",method = RequestMethod.GET)    
	    public ModelAndView delete(@PathVariable String bookcode){    
	        bookService.delete(bookcode);   
	      
	        return new ModelAndView("redirect:/viewBook");    
	    } 
	    
	    
	    
	    
	    
	    //only edit trial
	    @RequestMapping(value="/SaveEditBook",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("book") Book book){    
	      
	    	bookService.update(book);    
	        return "redirect:/viewBook";    
	    }    
	    @RequestMapping(value="/editbook/{bookcode}")    
	    public String edit(@PathVariable String bookcode, Model m){    
	        Book book=bookService.getBookByBookcode(bookcode);    
	        m.addAttribute("command",book);  
	        return "bookeditform";    
	    }    
	    
	   
	    @RequestMapping("/searchbook")    
	    public String searchBook(Model m){    
	        List<Book> list=bookDao.getBook();    
	        m.addAttribute("list",list); 
	       m.addAttribute("book", new Book());
			
	       
	        return "viewBook";    
	    }    
	    
	    @RequestMapping(value="/viewperbook",method = RequestMethod.POST)    
	    public String viewselectedbook(@ModelAttribute("book") Book book, Model m){    
	    	
			
	    	 List<Book> list = bookDao.getBookByBooktype(book.getBookType());  
	     
	    	  m.addAttribute("list",list); 
	       
	        return "viewperbook";    
	    } 
	   
	    
	  
	
}
