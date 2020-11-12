/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Venkata
 */
// Recursive Java program to print all files 

// in a folder(and sub-folders) 
 


import java.io.File;
import java.io.IOException;

import java.nio.file.Path;

import java.nio.file.Files;

import java.nio.file.attribute.BasicFileAttributes;

import java.nio.file.attribute.FileTime;

import java.text.SimpleDateFormat;

import java.util.*;


public class File_Print 
{	
    static String month[] = {"January" , "February" , "March" , "April","May","June","July","August","September","October","November","December"};	
    static Map<String,Set<String>> mp = new HashMap<String,Set<String>>(); 
    static void RecursivePrint(File[] arr,int index,int level) throws IOException  	
    {	
        // terminate condition 		
        if(index == arr.length) 		
        {			
            return; 
        }
	// tabs for internal levels 
	for (int i = 0; i < level; i++) 		
        {			
            System.out.print("\t"); 		
        }		
        // for files 		
        if(arr[index].isFile()) 		
        { 			        	        
            // File myfile = new File(arr[index].getName());
            Path path = arr[index].toPath();	        
            BasicFileAttributes fatr = Files.readAttributes(path, BasicFileAttributes.class);	        	        	        
            FileTime time = fatr.creationTime();		    		    
            String pattern = "MM"; 
            // yyyy-MM-dd		    
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);		    
            String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );		    
            int i = Integer. parseInt(formatted)-1;			
            if(mp.get(month[i])==null)			
            {				
                Set<String> set = new HashSet<String>();		        
                mp.put(month[i], set);		        
                mp.get(month[i]).add(arr[index].getName());			
            }			
            else			
            {				
                mp.get(month[i]).add(arr[index].getName());			
            }		
        }		
        // for sub-directories 		
        else if(arr[index].isDirectory()) 		
        { 			
            // System.out.println("[" + arr[index].getName() + "]"); 
            // directory name						
            // recursion for sub-directories 			
            RecursivePrint(arr[index].listFiles(), 0, level + 1); 
	} 					
        // recursion for main directory 	
        RecursivePrint(arr,++index, level); 	
    } 
    // Driver Method 	
    public static void main(String[] args) 	
    { 		
        // Provide full path for directory(change accordingly) 		
        String maindirpath = "C:\\Users\\Venkata\\Downloads\\FilesTest"; 						
        // File object 		
        File maindir = new File(maindirpath); 				
        if(maindir.exists() && maindir.isDirectory()) 		
        { 			
            // array for files and sub-directories 			
            // of directory pointed by maindir 			
            File arr[] = maindir.listFiles(); 						
            // System.out.println("**********************************************"); 			
            System.out.println("Files from main directory : " + maindir); 			
            // System.out.println("**********************************************"); 						
            // Calling recursive method			
            try			
            {				
                RecursivePrint(arr,0,0); 			
            }			
            catch (Exception e)			
            {				
                System.out.print(e);			
            }		
        }	
        for(int i=0; i<month.length; i++)
        {
                if(mp.get(month[i])!=null) 
                {
                    System.out.println("Files in " + month[i] +":"+mp.get(month[i]).size());
                } 
        }	
    } 
} 

