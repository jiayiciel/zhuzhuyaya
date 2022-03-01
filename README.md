## Usage of this CLI Application
### *by Anlan Xu*  
#

I am here to give you instructions of the Usage of this CLI Apllication. Please read this with your patience.

In this Application, you can see the *"CLIRunner.java"* has the *main( )* method, so you can first runner this file. And you should see the default help masage printed in the console, like below.

    usage: txt_filler [-cf <path>] [-e] [-et <file>] [-h] [-l] [-lt <file>] [-od <path>]
    -cf,--csv-file <path>          accept a filename that holds the email template
    -e,--email                     only generate email messages
    -et,--email-template <file>    accept a filename that holds the email template, required if --email is used
    -h,--help                      print help information
    -l,--letter                    only generate letters
    -lt,--letter-template <file>   accept a filename that holds the letter template, required if --letter is used
    -od,--output-dir <path>        accept the name of a folder, all output is placed in this folder


For the CLI arguments input, if you use IntellIJ, it is workable to make the input in "Edit Configuration" -> "Build and run" -> "Program arguments".

And I will give you examples of command lins.

## *example 1*  

    --email --email-template docs\\email-template.txt --output-dir emails\\ --csv-file docs/insurance-company-members.csv

This command line do things: generate email with **email-template.txt** and **insurance-campany-member.csv**. print the generation results in **console** and write the results into **emails** folder as **firstname_lastname.txt**

## *example 2*  

    --letter --letter-template docs\\letter-template.txt --output-dir letters\\ --csv-file docs/insurance-company-members.csv

This command line do things: generate email with **letter-template.txt** and **insurance-campany-member.csv**. print the generation results in **console** and write the results into **letters** folder as **firstname_lastname.txt**

## *example 3*  

    --letter --letter-template docs\\letter-template.txt --csv-file docs/insurance-company-members.csv
    --email --email-template docs\\email-template.txt --csv-file docs/insurance-company-members.csv

If you input example1 and example2 without the "--output-dir", like the example3 , and you will find generation result **Only In Console**, but nothing in folder. Because you do not proide a folder path.

## *example 4*  

    --letter --letter-template docs\\letter-template.txt --output-dir letters\\
    --email --email-template docs\\email-template.txt --output-dir emails\\

If you input example1 and example2 without the "--csv-file", you will find the application do the **same** things as example1 and example2. Because I give the "--csv-file" a **defult value**, making it point to "docs/insurance-company-members.csv".

## *example 5 (errors example)*  
    
    --letter
    --letter --email-template docs\\email-template.txt --output-dir emails\\

If you make input like this, you will find error like below

    --letter provided but no --letter-template was given

 /  
 /

    --email
    --email --letter-template docs\\letter-template.txt --output-dir letters\\
If you make input like this, you will find error like below  

    --email provided but no --email-template was given


# *Before End*

I also write my own letter-template and email-template and you can find them in **docs** folder!  
You can use CLI arguments below to try them!

    --email --email-template docs\\email-template-anlanxu.txt --output-dir emails\\
    --letter --letter-template docs\\letter-template-anlanxu.txt --output-dir letters\\
 
Thanks for using my CLI application. And if you have any question of using my application, welcome to contact me with the my email 
"xu.anl@northeastern.edu"# CS5010_Assignment3
