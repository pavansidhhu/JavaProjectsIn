package LibraryManagementSystem;

import StudentManagement.Student;




public class Library{
        private int Bookid;
        private String Bookname;
        private String author;
        private String issuedDate;
        private String returnDate;


        public Library(int Bookid,String Bookname,String author ,String issuedDate,String returnDate ) {
            this.Bookid=Bookid;
            this.Bookname=Bookname;
            this.author=author;
            this.returnDate=returnDate;
            this.issuedDate=issuedDate;
        }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookid() {
        return Bookid;
    }

    public void setBookid(int bookid) {
        Bookid = bookid;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String toString(){
            return Bookid+" "+Bookname+" "+author+" "+issuedDate+" "+returnDate;
        }


}

