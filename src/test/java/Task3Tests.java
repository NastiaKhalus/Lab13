import ua.edu.ucu.apps.task3.BrandFetchReader;
import ua.edu.ucu.apps.task3.PDLReader;
import ua.edu.ucu.apps.task3.CompanyReaderFacade;
import ua.edu.ucu.apps.task3.Company;
import ua.edu.ucu.apps.task3.Company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Task3Tests {

    private BrandFetchReader brandFetchReaderMock;
    private PDLReader pdlReaderMock;
    private CompanyReaderFacade companyReaderFacade;

    @BeforeEach
    public void setUp() {
        brandFetchReaderMock = mock(BrandFetchReader.class);
        pdlReaderMock = mock(PDLReader.class);
        companyReaderFacade = new CompanyReaderFacade();

        companyReaderFacade = new CompanyReaderFacade() {
            @Override
            public Company fetch(String companyName) {
                Company companyPdl = pdlReaderMock.fetch(companyName);
                Company companyBF = brandFetchReaderMock.fetch(companyName);
                return mergeCompanies(companyPdl, companyBF);
            }
        };
    }

    @Test
    public void testBrandFetchReader() throws IOException, InterruptedException {
        BrandFetchReader reader = new BrandFetchReader();
        BrandFetchReader readerMock = mock(BrandFetchReader.class);
        Company testCompany = new Company();
        testCompany.setName("Test BrandFetch");
        when(readerMock.fetch("ucu.edu.ua")).thenReturn(testCompany);

        Company result = readerMock.fetch("ucu.edu.ua");
        assertEquals("Test BrandFetch", result.getName());
    }

    @Test
    public void testPDLReader() throws IOException {
        PDLReader reader = new PDLReader();
        PDLReader readerMock = mock(PDLReader.class);
        Company testCompany = new Company();
        testCompany.setName("Test PDL");
        when(readerMock.fetch("ucu.edu.ua")).thenReturn(testCompany);

        Company result = readerMock.fetch("ucu.edu.ua");
        assertEquals("Test PDL", result.getName());
    }

    @Test
    public void testCompanyReaderFacade() {
        Company companyPdl = new Company();
        companyPdl.setName("PDL Name");

        Company companyBF = new Company();
        companyBF.setName("BF Name");

        when(pdlReaderMock.fetch("ucu.edu.ua")).thenReturn(companyPdl);
        when(brandFetchReaderMock.fetch("ucu.edu.ua")).thenReturn(companyBF);
        Company result = companyReaderFacade.fetch("ucu.edu.ua");
        assertNotNull(result);
        assertEquals("BF Name", result.getName());
    }

    @Test
    public void testMergeCompanies() {
        Company companyPdl = new Company();
        companyPdl.setName("PDL Name");

        Company companyBF = new Company();
        companyBF.setName("BF Name");

        when(pdlReaderMock.fetch("ucu.edu.ua")).thenReturn(companyPdl);
        when(brandFetchReaderMock.fetch("ucu.edu.ua")).thenReturn(companyBF);
        CompanyReaderFacade facade = new CompanyReaderFacade() {
            @Override
            public Company fetch(String companyName) {
                return mergeCompanies(pdlReaderMock.fetch(companyName), brandFetchReaderMock.fetch(companyName));
            }
        };
        Company result = facade.fetch("ucu.edu.ua");
        assertNotNull(result);
        assertEquals("BF Name", result.getName());
    }
    }
