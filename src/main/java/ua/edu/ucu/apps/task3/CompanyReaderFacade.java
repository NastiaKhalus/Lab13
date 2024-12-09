package ua.edu.ucu.apps.task3;

public class CompanyReaderFacade {
    private PDLReader pdlReader;
    private BrandFetchReader brandFetchReader;

    public CompanyReaderFacade(){
        this.pdlReader = new PDLReader();
        this.brandFetchReader = new BrandFetchReader();
    }

    public Company fetch(String companyName) {
        Company companyPdl = pdlReader.fetch(companyName);
        Company companyBF = brandFetchReader.fetch(companyName);
    
        return mergeCompanies(companyPdl, companyBF);
    }
    protected Company mergeCompanies(Company companyPdl, Company companyBF) {
        Company mergedCompany = new Company();
    
        mergedCompany.setName(
            companyBF.getName() != null ? companyBF.getName() : companyPdl.getName()
        );        
        return mergedCompany;
    }
}
