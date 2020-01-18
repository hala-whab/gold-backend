package me.gold;

import me.gold.model.*;
import me.gold.reporesistory.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
@RestController
@CrossOrigin

public class BlogController {

    @Autowired
    CustomerRespository CRespository;
    @Autowired
    DsellRespository DRepo;
    @Autowired
    debtdetailsRespository ddR;
    @Autowired
    debtRespository debtR;
    @Autowired
    CreditRespository creditRespository;
    @Autowired
    ExpensivesRespository expensivesRespository;
    @Autowired
    loanRespository loanRespository;
    @Autowired
    SaveRespository saveRespository;
    @Autowired
    DpurchaseRespository dpurchaseRespository;
    @Autowired
    debtpurchaseRespository debtpurchaseRespository;
    @Autowired
    debtdetailsPurchaseRespository debtdetailsPurchaseRespository;
    @Autowired
    HDRespository hdRespository;
    //debtdetailsAPIs
    @GetMapping("/getdebtpaymentdetailsbyid/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<debtdetails> find(@PathVariable String id) {
        int debtId = Integer.parseInt(id);
        return ddR.finddebtbydebtid(id);
    }

    @PostMapping("/postdebtdetailsbyid")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void postdd(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        System.out.println("BODY "+body);
        JSONObject obj = (JSONObject) parser.parse(body.toString());

        ddR.save(new debtdetails(obj.get("id").toString(), obj.get("no_of_grams").toString(), obj.get("cash_paid").toString(), obj.get("card_paid").toString(), obj.get("date").toString(), obj.get("duedate").toString(),obj.get("employee_in_charge").toString()));

        Integer x = Integer.parseInt(obj.get("id").toString());
        if(Integer.parseInt(obj.get("remaning").toString())==0) {
            ddR.deletwhereremaningequalzero(x);
            debtR.deletwhereremaningequalzero(x);
        }
            else{
                debtR.modifyremaning(obj.get("remaning").toString(),obj.get("duedate").toString(), x);
            }


        }


    //debtAPIs
    @PostMapping("/Debt")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void debt(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        int debtId = Integer.parseInt(obj.get("customer_id").toString());
        Customer x = CRespository.findOne(debtId);
        debtR.save(new debt(obj.get("customer_id").toString(), x.getName(), obj.get("weight").toString(), obj.get("dept_grams").toString(), obj.get("dept_grams").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("duedate").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
    }

    @PostMapping("/posTRANS")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void POSTTRAN(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        int debtId = Integer.parseInt(obj.get("customer_id").toString());
        Customer x = CRespository.findOne(debtId);
        debtR.save(new debt(obj.get("customer_id").toString(), x.getName(), obj.get("weight").toString(), obj.get("dept_grams").toString(), obj.get("dept_grams").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("duedate").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
    }

    @GetMapping("/getdebt")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<debt> getdebt() {
        return debtR.findAll();
    }

    @GetMapping("/getdebtforcustomer/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<debt> finddebt(@PathVariable String id) {
        int debtId = Integer.parseInt(id);
        return debtR.finddebtbycustomerid(id);
    }

    @DeleteMapping("/deletewhereremaning=zero/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void delete (@PathVariable String id){
        int Id= Integer.parseInt(id);
        debtR.deletwhereremaningequalzero(Id);
    }
//customerApi
       @PostMapping("/addCustomer")
       @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
       @ResponseBody
public void create(@RequestBody JSONObject body) throws ParseException {
        System.out.println( body +"+body+");
    JSONParser parser = new JSONParser();
    JSONObject obj = (JSONObject) parser.parse(body.toString());
    CRespository.save(new Customer(obj.get("name").toString(), obj.get("telephone").toString(), obj.get("anotherTelephone").toString(), obj.get("address").toString(),obj.get("employee_in_charge").toString()));
}

    @GetMapping("/findCustomer")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @ResponseBody
    public List<Customer> getcustomers() {

        return CRespository.findAll();
    }

//DirectsellApi
    @PostMapping("/Dirctsell")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void apply(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));

    }
    //DirectbuyApi
    @PostMapping("/Dirctspurchase")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void dirctbuy(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        System.out.println(body);
        dpurchaseRespository.save(new Dpurchase(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));

    }
    @PostMapping("/Debtpurchase")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void debtpurchase(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        int debtId = Integer.parseInt(obj.get("customer_id").toString());
        Customer x = CRespository.findOne(debtId);
        debtpurchaseRespository.save(new debtpurchase(obj.get("customer_id").toString(), x.getName(), obj.get("weight").toString(), obj.get("dept_grams").toString(), obj.get("dept_grams").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("duedate").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
    }
    //debtpurchaseAPIs
    @GetMapping("/getdebtpurchase")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<debtpurchase> getdebtpurchase() {
        return debtpurchaseRespository.findAll();
    }

    @GetMapping("/getdebtpurchaseforcustomer/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<debtpurchase> finddebtpurchase(@PathVariable String id) {
        int debtId = Integer.parseInt(id);
        return debtpurchaseRespository.finddebtbycustomerid(id);
    }

    @DeleteMapping("/deletedebtpurchasewhereremaning=zero/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void deletedebtpurchase (@PathVariable String id){
        int Id= Integer.parseInt(id);
        debtpurchaseRespository.deletwhereremaningequalzero(Id);
    }
    //debtpurchasedetailsAPI
    @GetMapping("/getdebtpurchasepaymentdetailsbyid/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<debtpurchasedetails> findp(@PathVariable String id) {
        int debtId = Integer.parseInt(id);
        return debtdetailsPurchaseRespository.finddebtbpydebtid(id);
    }

    @PostMapping("/postdebtpdetailsbyid")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void postddp(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        System.out.println("BODY "+body);
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        debtdetailsPurchaseRespository.save(new debtpurchasedetails(obj.get("id").toString(), obj.get("no_of_grams").toString(), obj.get("cash_paid").toString(), obj.get("card_paid").toString(), obj.get("date").toString(), obj.get("duedate").toString(),obj.get("employee_in_charge").toString()));

        Integer x = Integer.parseInt(obj.get("id").toString());

        if(Integer.parseInt(obj.get("remaning").toString())==0) {
            debtpurchaseRespository.deletwhereremaningequalzero(x);
            debtdetailsPurchaseRespository.deletwhereremaningequalzero(x);
        }
        else{
            debtpurchaseRespository.modifyremaning(obj.get("remaning").toString(),obj.get("duedate").toString(), x);
        }


    }


//I should do daily sell report

//CreditApi
    @GetMapping("/getcredit")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<credit> getcredit() {
        return creditRespository.findAll();
    }

    @GetMapping("/getcreditforcustomer/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<credit> findcreditforcustomer(@PathVariable String id) {
        return creditRespository.findcreditbycustomerid(id);
    }
    @PostMapping("/credit")

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void credit(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        int creditId = Integer.parseInt(obj.get("customer_id").toString());
        Customer x = CRespository.findOne(creditId);
        creditRespository.save(new credit(obj.get("beneficial_id").toString(), x.getName(), obj.get("benefit_amount").toString(), obj.get("credit_type").toString(), obj.get("benfit_date").toString(),obj.get("employee_in_charge").toString()));
    }
    @DeleteMapping("/deletecreditwhentakenall/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void deletecredit (@PathVariable String id){
        int Id= Integer.parseInt(id);
        creditRespository.deletwherecreditequalzero(Id);
    }

    @PostMapping("/takesomeofcredit")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void editcredit(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
       Integer x = Integer.parseInt(obj.get("id").toString());
        creditRespository.modifycredit(obj.get("benefit_amount").toString(), x);
    }
//SaveApi

    @PostMapping("/updatesSaveWhenDebtSell")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesSaveWhenDebtSell(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        System.out.println("body    "+body);
        // DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
        save ssave=saveRespository.getlastrow();
        switch (obj.get("Gram_Type").toString())
        {
            case "Bahrani":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setBah_Grams(String.valueOf(Float.parseFloat(ssave.getBah_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Kweitei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setKwe_Grams(String.valueOf(Float.parseFloat(ssave.getKwe_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            case  "Sudanei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setSud_Grams(String.valueOf(Float.parseFloat(ssave.getSud_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Turkey":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setTur_Grams(String.valueOf(Float.parseFloat(ssave.getTur_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            default:
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setUsed_Grams(String.valueOf(Float.parseFloat(ssave.getUsed_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
        }
        double x;
        switch (obj.get("Payment").toString().toLowerCase()){
            case "cash":
                x=(((Double.parseDouble(obj.get("weight").toString())-(Double.parseDouble(obj.get("dept_grams").toString())))*(Double.parseDouble(obj.get("gram_cash_price").toString()))));
                System.out.println("(Double.parseDouble(obj.get(\"weight\").toString())=  "+(Double.parseDouble(obj.get("weight").toString())));
                System.out.println("(Double.parseDouble(obj.get(\"dept_grams\").toString()))=    "+(Double.parseDouble(obj.get("dept_grams").toString())));
                System.out.println("(Double.parseDouble(obj.get(\"gram_cash_price\").toString()) =    "+(Double.parseDouble(obj.get("gram_cash_price").toString())));
                System.out.println("x+  "+x);
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
                break;
            case "card":
                x=(((Double.parseDouble(obj.get("weight").toString())-(Double.parseDouble(obj.get("dept_grams").toString()))*(Double.parseDouble(obj.get("gram_card_price").toString())))));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
            default:
                double a=(Double.parseDouble(obj.get("gram_card_price").toString()))*(Double.parseDouble(obj.get("No_Of_grams_Paid_card").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+a));
                double b=(Double.parseDouble(obj.get("No_Of_grams_Paid_cash").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                x=a+b;
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+b));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
                break;
        }
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());
        saveRespository.save(ssave);

    }

    @PostMapping("/updatesSaveWhenDebtpurshace")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesSaveWhenDebtpurshace(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        // DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
        save ssave=saveRespository.getlastrow();
        switch (obj.get("Gram_Type").toString())
        {
            case "Bahrani":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setBah_Grams(String.valueOf(Float.parseFloat(ssave.getBah_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Kweitei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setKwe_Grams(String.valueOf(Float.parseFloat(ssave.getKwe_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            case  "Sudanei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setSud_Grams(String.valueOf(Float.parseFloat(ssave.getSud_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Turkey":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setTur_Grams(String.valueOf(Float.parseFloat(ssave.getTur_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            default:
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setUsed_Grams(String.valueOf(Float.parseFloat(ssave.getUsed_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
        }
        double x;
        switch (obj.get("Payment").toString().toLowerCase()){
            case "cash":
                x=(((Double.parseDouble(obj.get("weight").toString())-(Double.parseDouble(obj.get("dept_grams").toString())))*(Double.parseDouble(obj.get("gram_cash_price").toString()))));
                System.out.println("(Double.parseDouble(obj.get(\"weight\").toString())=  "+(Double.parseDouble(obj.get("weight").toString())));
                System.out.println("(Double.parseDouble(obj.get(\"dept_grams\").toString()))=    "+(Double.parseDouble(obj.get("dept_grams").toString())));
                System.out.println("(Double.parseDouble(obj.get(\"gram_cash_price\").toString()) =    "+(Double.parseDouble(obj.get("gram_cash_price").toString())));
                System.out.println("x+  "+x);
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())-x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())-x));
                break;
            case "card":
                x=((((Double.parseDouble(obj.get("weight").toString())-(Double.parseDouble(obj.get("dept_grams").toString())))*(Double.parseDouble(obj.get("gram_card_price").toString())))));
                System.out.println("(Double.parseDouble(obj.get(\"weight\").toString())=  "+(Double.parseDouble(obj.get("weight").toString())));
                System.out.println("(Double.parseDouble(obj.get(\"dept_grams\").toString()))=    "+(Double.parseDouble(obj.get("dept_grams").toString())));
                System.out.println("(Double.parseDouble(obj.get(\"gram_cash_price\").toString()) =    "+(Double.parseDouble(obj.get("gram_card_price").toString())));
                System.out.println("xxx =  "+x);
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())-x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())-x));
            default:
                double a=(Double.parseDouble(obj.get("gram_card_price").toString()))*(Double.parseDouble(obj.get("No_Of_grams_Paid_card").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())-a));
                double b=(Double.parseDouble(obj.get("No_Of_grams_Paid_cash").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                x=a+b;
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())-b));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())-x));
                break;
        }
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());
        saveRespository.save(ssave);

    }


    @PostMapping("/updatesSaveWhenDerctbuy")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesSaveWhenDerctbuy(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        // DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
        save ssave=saveRespository.getlastrow();
        System.out.println(ssave.toString());
        switch (obj.get("Gram_Type").toString())
        {
            case "Bahrani":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setBah_Grams(String.valueOf(Float.parseFloat(ssave.getBah_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Kweitei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setKwe_Grams(String.valueOf(Float.parseFloat(ssave.getKwe_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            case  "Sudanei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setSud_Grams(String.valueOf(Float.parseFloat(ssave.getSud_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Turkey":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setTur_Grams(String.valueOf(Float.parseFloat(ssave.getTur_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
            default:
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())+Float.parseFloat(obj.get("weight").toString())));
                ssave.setUsed_Grams(String.valueOf(Float.parseFloat(ssave.getUsed_Grams())+Float.parseFloat(obj.get("weight").toString())));
                break;
        }
        double x;
        switch (obj.get("Payment").toString().toLowerCase()){
            case "cash":
                x=(Double.parseDouble(obj.get("weight").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())-x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())-x));
                break;
            case "card":
                x=(Double.parseDouble(obj.get("weight").toString()))*(Double.parseDouble(obj.get("gram_card_price").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())-x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())-x));
            default:
                double a=(Double.parseDouble(obj.get("gram_card_price").toString()))*(Double.parseDouble(obj.get("No_Of_grams_Paid_card").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())-a));
                double b=(Double.parseDouble(obj.get("No_Of_grams_Paid_cash").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                x=a+b;
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())-b));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())-x));
                break;
        }
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());

        saveRespository.save(ssave);
    }
    @PostMapping("/updatesSaveWhenDirctsell")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesSaveWhenDerctsell(@RequestBody JSONObject body) throws ParseException {
        System.out.println(" fffffffffffff "+body);
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        System.out.println(" direct sell input  " + body);
        // DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
        save ssave=saveRespository.getlastrow();
        System.out.println(ssave.toString());
        switch (obj.get("Gram_Type").toString())
        {
            case "Bahrani":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setBah_Grams(String.valueOf(Float.parseFloat(ssave.getBah_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Kweitei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setKwe_Grams(String.valueOf(Float.parseFloat(ssave.getKwe_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            case  "Sudanei":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setSud_Grams(String.valueOf(Float.parseFloat(ssave.getSud_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            case "Turkey":
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setTur_Grams(String.valueOf(Float.parseFloat(ssave.getTur_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
            default:
                ssave.setTotal_Grams(String.valueOf(Float.parseFloat(ssave.getTotal_Grams())-Float.parseFloat(obj.get("weight").toString())));
                ssave.setUsed_Grams(String.valueOf(Float.parseFloat(ssave.getUsed_Grams())-Float.parseFloat(obj.get("weight").toString())));
                break;
        }
        double x;
        switch (obj.get("Payment").toString().toLowerCase()){
            case "cash":
                x=(Double.parseDouble(obj.get("weight").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
                break;
            case "card":
                x=(Double.parseDouble(obj.get("weight").toString()))*(Double.parseDouble(obj.get("gram_card_price").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
            default:
                double a=(Double.parseDouble(obj.get("gram_card_price").toString()))*(Double.parseDouble(obj.get("No_Of_grams_Paid_card").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+a));
                double b=(Double.parseDouble(obj.get("No_Of_grams_Paid_cash").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                x=a+b;
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+b));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
                break;
        }
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());


        saveRespository.save(ssave);
    }


    @PostMapping("/updatesSaveWhendebtpaid")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesSaveWhendebtpaid(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        // DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
        save ssave=saveRespository.getlastrow();
        double x;
        double y;

    x=(Double.parseDouble(obj.get("cash_paid").toString()));
    y=(Double.parseDouble(obj.get("card_paid").toString()));
    ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+x));
    ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));

    ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+y));
    ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+y));


     //save to save + figure how to find the last row
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());
        saveRespository.save(new save(ssave.getTotal_Grams(),ssave.getBah_Grams(),ssave.getKwe_Grams(),ssave.getSud_Grams(),ssave.getUsed_Grams(),ssave.getTur_Grams(),ssave.getCash(),ssave.getBank(),ssave.getMoney(),ssave.getEmployee_in_charge()));
    }
    @PostMapping("/updatesSaveWhenpurshaseloanpaid")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesSaveWhenpurshaseloanpaid(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        // DRepo.save(new Dsell(obj.get("Gram_Type").toString(), obj.get("Details").toString(), obj.get("weight").toString(), obj.get("Payment").toString(), obj.get("gram_cash_price").toString(), obj.get("gram_card_price").toString(), obj.get("No_Of_grams_Paid_cash").toString(), obj.get("No_Of_grams_Paid_card").toString(),obj.get("date").toString(),obj.get("employee_in_charge").toString()));
        save ssave=saveRespository.getlastrow();
        double x;
        double y;

        x=(Double.parseDouble(obj.get("cash_paid").toString()));
        y=(Double.parseDouble(obj.get("card_paid").toString()));
        ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+x));
        ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
        ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+y));
        ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+y));
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());
        saveRespository.save(ssave);
    }
    @PostMapping("/updatesavewhenSellHD")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updatesavewhenSellHD(@RequestBody JSONObject body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(body.toString());
        save ssave=saveRespository.getlastrow();
        double x;
        double y;
        switch (obj.get("Payment").toString().toLowerCase()){
            case "cash":
                x=(Double.parseDouble(obj.get("weight").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
                break;
            case "card":
                x=(Double.parseDouble(obj.get("weight").toString()))*(Double.parseDouble(obj.get("gram_card_price").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+x));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
            default:
                double a=(Double.parseDouble(obj.get("gram_card_price").toString()))*(Double.parseDouble(obj.get("No_Of_grams_Paid_card").toString()));
                ssave.setBank(String.valueOf(Double.parseDouble(ssave.getBank())+a));
                double b=(Double.parseDouble(obj.get("No_Of_grams_Paid_cash").toString()))*(Double.parseDouble(obj.get("gram_cash_price").toString()));
                x=a+b;
                ssave.setCash(String.valueOf(Double.parseDouble(ssave.getCash())+b));
                ssave.setMoney(String.valueOf(Double.parseDouble(ssave.getMoney())+x));
                break;
        }
        ssave.setEmployee_in_charge(obj.get("employee_in_charge").toString());


        saveRespository.save(ssave);
    }
    @GetMapping("/getSaveinfo")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public save getSaveinfo() {
        return saveRespository.getlastrow();
    }

//EmployeesAPI

// Expensives/API
//Hard courrency
@PostMapping("/addHD")
@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
public void addHD(@RequestBody JSONObject body) throws ParseException {
    JSONParser parser = new JSONParser();
    JSONObject obj = (JSONObject) parser.parse(body.toString());
    System.out.println("body HD"+obj);
    hdRespository.save(new HD(obj.get("type").toString(),obj.get("country").toString(),"0"));
    }
    @GetMapping("/getHD")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<HD> findHD() {
        return hdRespository.findAll();
    }
}

