package ua.edu.ucu.apps.task3;

public class Main {
    public static void main(String[] args) {
        CompanyReaderFacade companyReaderFacade = new CompanyReaderFacade();
        Company company = companyReaderFacade.fetch("ucu.edu.ua");
        System.out.println(company);
    }
}

