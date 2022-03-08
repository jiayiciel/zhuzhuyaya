
User Guide:

    usage: txt_filler [-cf <path>] [-e] [-et <file>] [-h] [-l] [-lt <file>] [-od <path>]
    -cf,--csv-file <path>          accept a filename that holds the email template
    -e,--email                     only generate email messages
    -et,--email-template <file>    accept a filename that holds the email template, required if --email is used
    -h,--help                      print help information
    -l,--letter                    only generate letters
    -lt,--letter-template <file>   accept a filename that holds the letter template, required if --letter is used
    -od,--output-dir <path>        accept the name of a folder, all output is placed in this folder


To run in Intellij, first do "Edit Configuration" -> "Build and run" -> "Program arguments".


## *example command to generate emailss with default email template*  

    --email --email-template docs/email-template.txt --output-dir emails/ --csv-file docs/insurance-company-members.csv

## *example command to generate letters with default letter template*  

    --letter --letter-template docs/letter-template.txt --output-dir letters/ --csv-file docs/insurance-company-members.csv

## *example command to generate emails and letters with customized email and letter template*  

    --letter --letter-template file_docs/letter-template-test.txt --output-dir letters/ --csv-file docs/insurance-company-members.csv
    --email --email-template file_docs/email-template-test.txt --output-dir emails/ --csv-file docs/insurance-company-members.csv