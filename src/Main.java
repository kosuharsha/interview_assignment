/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Venkata
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


public class Main {
	
	public static void main(String [] args) {
		
		A a = new A();
		a.b = new A();
		
		A c = new A();
		c.b = new A();
		c.b.a = new A();
		
		a.b.c = c.b.a;
	}

}

