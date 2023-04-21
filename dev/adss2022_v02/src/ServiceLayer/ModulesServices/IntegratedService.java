package ServiceLayer.ModulesServices;

import BussinessLayer.Objects.Order;
import BussinessLayer.Objects.Supplier;
import BussinessLayer.Objects.ShiftType;
import DataAccessLayer.Dal.DBHandler;
import DataAccessLayer.Dal.ItemOrderDAO;
import InterfaceLayer.SupplierCLI;
import ServiceLayer.*;
import ServiceLayer.ServiceObjects.productS;
import ServiceLayer.ServiceObjects.reportS;
import ServiceLayer.ServiceObjects.*;

import java.sql.Date;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntegratedService {
    private final ServiceModelEmployees employees;
    private final ServiceModelTransform transform;
    private final DataService dataService;

    private InventoryService inventoryService;
    private SuppliersService suppliersService;
    private static IntegratedService instance;

    private IntegratedService() {
        dataService = new DataService();
        employees = new ServiceModelEmployees();
        transform = new ServiceModelTransform();
        inventoryService = InventoryService.getInstance();
        suppliersService = SuppliersService.getInstance();
    }

    public static IntegratedService getInstance() {
        if (instance == null)
            instance = new IntegratedService();
        return instance;
    }

    public void AddSite(int idSite, String contactPerson, String phoneNumber, String address, String shippingArea) {
        transform.AddSite(idSite, contactPerson, phoneNumber, address, shippingArea);
    }

    public HashMap<Integer, SiteS> DisplaySites() {
        return transform.DisplaySites();
    }

    public SiteS getSite(int id) {
        employees.TransportManager();
        return transform.getSite(id);
    }

    public void UpdateSiteContactPerson(int idSite, String contactPerson) {
        employees.TransportManager();
        transform.UpdateSiteContactPerson(idSite, contactPerson);
    }

    public void UpdateSitePhoneNumber(int idSite, String phoneNumber) {
        employees.TransportManager();
        transform.UpdateSitePhoneNumber(idSite, phoneNumber);
    }

    public void UpdateSiteAddress(int idSite, String address) {
        employees.TransportManager();
        transform.UpdateSiteAddress(idSite, address);
    }

    public void UpdateSiteShippingArea(int idSite, String shippingArea) {
        employees.TransportManager();
        transform.UpdateSiteShippingArea(idSite, shippingArea);
    }

    //truckOperations
    //add Truck
    //truckManager
    public void AddTruck(String licenseNumber, String model, double truckWeight, double maxWeight, String typeOfLicense) {
        employees.TransportManager();
        transform.AddTruck(licenseNumber, model, truckWeight, maxWeight, typeOfLicense);
    }

    public HashMap<Integer, TruckS> DisplayTrucks() {
        return transform.DisplayTrucks();
    }

    public TruckS getTruck(int id) {
        employees.TransportManager();
        return transform.getTruck(id);
    }

    public void UpdateTruckLicenseNumber(int idTruck, String licenseNumber) {
        employees.TransportManager();
        transform.UpdateTruckLicenseNumber(idTruck, licenseNumber);
    }

    public void UpdateTruckModel(int idTruck, String model) {
        employees.TransportManager();
        transform.UpdateTruckModel(idTruck, model);
    }

    public void UpdateTruckWeight(int idTruck, double weight) {
        employees.TransportManager();
        transform.UpdateTruckWeight(idTruck, weight);
    }

    public void UpdateTruckMaxWeight(int idTruck, double maxWeight) {
        employees.TransportManager();
        transform.UpdateTruckMaxWeight(idTruck, maxWeight);
    }

    public void UpdateTruckLicenseType(int idTruck, String typeOfLicense) {
        employees.TransportManager();
        transform.UpdateTruckLicenseType(idTruck, typeOfLicense);
    }

    public HashMap<Integer, TruckS> displayAvailableTrucks(LocalDateTime date) {
        employees.TransportManager();
        return transform.displayAvailableTrucks(date);
    }

    //transportOperations
    //TransportManager
    //addTransport
    public void AddTransport(LocalDateTime date, int driverDocNum, int idsource, int idTruck, double totalWeight) {
        employees.TransportManager();
        transform.AddTransport(date, driverDocNum, idsource, idTruck, totalWeight, employees.getAvailableDriver(date));
    }

    public TransportS getTransport(int id) {
        employees.TransportManager();
        return transform.getTransport(id);
    }

    public HashMap<Integer, TransportS> DisplayTransports() {
        return transform.DisplayTransports();
    }

    public void deleteTransport(int idTransport) {
        employees.TransportManager();
        transform.deleteTransport(idTransport);
    }


    public void UpdateTransportDate(int idTransport, LocalDateTime date) {
        employees.TransportManager();
        transform.UpdateTransportDate(idTransport, date);
    }

    public void UpdateTransportDriverDocNum(int idTransport, int DriverDocNum) {
        employees.TransportManager();
        transform.UpdateTransportDriverDocNum(idTransport, DriverDocNum);
    }

    public void UpdateTransportTotalWeight(int idTransport, double totalWeight) {
        employees.TransportManager();
        transform.UpdateTransportTotalWeight(idTransport, totalWeight);
    }

    public void UpdateTransportSource(int idTransport, int idSite) {
        employees.TransportManager();
        transform.UpdateTransportSource(idTransport, idSite);
    }

    public void RemoveTransportDestination(int idTransport, int idDestination) {
        employees.TransportManager();
        transform.RemoveTransportDestination(idTransport, idDestination);
    }

    public void addTransportDestination(int idTransport, int idDestination) {
        employees.TransportManager();
        transform.addTransportDestination(idTransport, idDestination);
    }

    public void UpdateTransportDriver(int idTransport, int idDriver) {
        employees.TransportManager();
        transform.UpdateTransportDriver(idTransport, employees.getDriver(idDriver));
    }

    public void UpdateTransportTruck(int idTransport, int idTruck) {
        employees.TransportManager();
        transform.UpdateTransportTruck(idTransport, idTruck);
    }

    public HashMap<Integer, TransportS> DisplayOldTransport() {
        employees.TransportManager();
        return transform.DisplayOldTransport();
    }

    public HashMap<Integer, TransportS> DisplayFutureTransport(int maxDay) {
        employees.TransportManager();
        return transform.DisplayFutureTransport(maxDay);
    }

    public HashMap<Integer, EmployeeS> displayAvailableDrivers(LocalDateTime date) {
        return employees.displayAvailableDrivers(date);
    }

    //shifts
    public void shiftArrange(LocalDate date, String shiftType, Integer shiftMannager, Map<String, LinkedList<Integer>> inputShift) {
        employees.shiftArrange(date, shiftType, shiftMannager, inputShift);
    }

    public void addShift(LocalDate date, String shiftType, Map<String, Integer> shiftStructure) {
        employees.addShift(date, shiftType, shiftStructure);
    }

    public void addShift(LocalDate date, LocalDate date1, String shiftType1) {
        employees.addShift(date, date1, shiftType1);
    }

    public List<ShiftS> displayShift(LocalDate start, LocalDate end) {
        return employees.displayShift(start, end);
    }

    public void deleteArrange(LocalDate date, String shiftType) {
        employees.deleteArrange(date, shiftType);
    }

    public void deleteEmployee(int id, LocalDate date1, String shiftTime) {
        employees.deleteEmployee(id, date1, shiftTime);
    }

    public void addEmployeeToShift(int id, LocalDate date1, String shiftTime) {
        employees.addEmployeeToShift(id, date1, shiftTime);
    }

    public void switchEmployee(int id1, int id2, LocalDate date1, String shiftTime) {
        employees.switchEmployee(id1, id2, date1, shiftTime);
    }

    public void switchManager(int id1, int id2, LocalDate date1, String shiftTime) {
        employees.switchManager(id1, id2, date1, shiftTime);
    }

    public void updateshift(LocalDate date1, String shiftTime, Map<String, Integer> structure) {
        employees.updateshift(date1, shiftTime, structure);
    }

    public void updateJobInShift(LocalDate date, String shiftTime, String job, int num) {
        employees.updateJobInShift(date, shiftTime, job, num);
    }

    public List<String> getJobType(String shiftTime) {
        return employees.getJobType(shiftTime);
    }

    //employee
    public void login(int id) {
        employees.login(id);
    }

    public List<MessageS> getUnreadMessages(String jobType) {
        return employees.getUnreadMessages(jobType);
    }

    //TODO new fun
    public void login(int id, String jobType) {
        employees.login(id, jobType);
    }


    public void logout() {
        employees.logout();
    }

    public void addConstraint(LocalDate date, String shift) {
        employees.addConstraint(date, shift);
    }

    public void deleteConstraint(LocalDate date, String shift) {
        employees.deleteConstraint(date, shift);
    }

    public Map<LocalDate, List<ShiftType>> displayConstraint() {
        return employees.displayConstraint();
    }

    public String myshift() {
        return employees.myshift();
    }

    //manager actions
    public void addEmployee(int id, String name, int bankAccount, int salary, String hiringCondition, String jobType, String licence) {
        employees.addEmployee(id, name, bankAccount, salary, hiringCondition, jobType, licence);
    }

    public List<EmployeeS> displayEmployees() {
        return employees.displayEmployees();
    }

    public String getDetails(int id) {
        return employees.getDetails(id);
    }

    public void finish(int id) {
        employees.finish(id);
    }

    public void updatebank(int id, int bank) {
        employees.updatebank(id, bank);
    }

    public void updateSalary(int id, int salary) {
        employees.updateSalary(id, salary);
    }

    public void updateJob(int id, String jobType) {
        employees.updateJob(id, jobType);
    }

    public void updateHiring(int id, String hiring) {
        employees.updateHiring(id, hiring);
    }

    public void addTrain(int id, String training) {
        employees.addTrain(id, training);
    }

    public String getJobTypeByID(int ID) {
        return employees.getJobTypeByID(ID);
    }

    public Map<String, List<EmployeeS>> getAvailableEmployees(LocalDate date, String shiftType) {
        return employees.displayAvailableEmployees(date, shiftType);
    }

    public boolean isDriver(String jobType) {
        return employees.isDriver(jobType);
    }

    //data operations
//    public void loadDataET() throws ParseException {
//        dataService.LoadData(employees, transform );
//    }

    public void DelData() throws ParseException {
        dataService.DelData(employees, transform);
    }

    public void startingProgram() throws ParseException {
        //DelData();
        // loadData();
        dataService.startingProgram(employees, transform,inventoryService,suppliersService);
    }


    public void loadData()  throws ParseException{
        //DBHandler.getInstance().Delete_Records_From_Tables();

        dataService.LoadData(employees, transform ,inventoryService,suppliersService);
//        inventoryService.loadData();
//        suppliersService.loadData();

        //if (inventoryResponse.isErrorOccurred())
           // return inventoryResponse;
        //return supplierResponse;
    }

    public Response deleteOrder(int orderID) {
        try {
            this.suppliersService.deleteOrder(orderID);
            this.inventoryService.deleteItemsOrder(orderID);
            this.transform.deleteTransportByOrderID(orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }


    public Response orderItems(String productToOrder, int periodic, List<DayOfWeek> days) {
        ResponseT<reportS> items = inventoryService.AddItemsToOrderReport(productToOrder);
        if (items.isErrorOccurred())
            return new Response(items.getErrorMessage());
        Map<Integer, Integer> productMap = items.getValue().getProducts();
        ResponseT<ServiceOrder> order = suppliersService.createPeriodicOrder(productMap, periodic, days);
        if(order.isErrorOccurred())
            return new Response(order.getErrorMessage());
        return new Response();

    }

    public ResponseT addItemsToOrder(int orderId, String itemIdAmountMap) {
        Map<Integer, Integer> order = new HashMap<Integer, Integer>();
        String[] partsOfOrder = itemIdAmountMap.split(",");
        for (String str : partsOfOrder) {
            if (!str.equals("") & str.contains(" ")) {
                String[] ProductNameAndQuantity = str.split(" ");
                int ID = 0;
                try {
                    ID = Integer.parseInt(ProductNameAndQuantity[0]);
                } catch (Exception e) {
                }
                order.putIfAbsent(ID, Integer.parseInt(ProductNameAndQuantity[1]));
            }
        }
        return suppliersService.addItemsToOrder(orderId, order);
    }

    public ResponseT<ServiceOrder> removeItemsFromOrder(int orderId, String[] itemIdsToRemove) {
        List<Integer> itemsToRemove = new LinkedList<>();
        for (String str : itemIdsToRemove) {
            itemsToRemove.add(Integer.parseInt(str));
        }
        return suppliersService.removeItemsFromOrder(orderId, itemsToRemove);
    }

    public Response receiveAllOrders(java.util.Date date) {
        return suppliersService.receiveAllOrders((Date) date);
    }

    public ResponseT<List<productS>> getAllProducts() {
        return this.inventoryService.getAllProducts();
    }

    public ResponseT<productS> getProductByID(int productId) {
        return this.inventoryService.getProductByID(productId);
    }

    public Response addProduct(String name, String manufacturer, int MinQuantity, double sellPrice,
                               String category, String subCat, String subSubCaty, double weight) {
        return this.inventoryService.addProduct(name, manufacturer, MinQuantity, sellPrice, category, subCat, subSubCaty, weight);
    }

    public Response removeProduct(int ProID) {
        return this.inventoryService.removeProduct(ProID);
    }


    public Response updateSellPrice(int ProID, double sellPrice) {
        return this.inventoryService.updateSellPrice(ProID, sellPrice);
    }

    //enter category id or the category name if the category doesn't exist
    public Response updateCategory(int ProID, String category, String categoryType) {
        return this.inventoryService.updateCategory(ProID, category, categoryType);
    }

    public Response moveItem(int ProID, int amountToMove, String newPlace, boolean toShelf) {
        return this.inventoryService.moveItem(ProID, amountToMove, newPlace, toShelf);
    }

    public Response moveOneItem(int ProID, int ItemID, String newPlace, boolean toShelf) {
        return this.inventoryService.moveOneItem(ProID, ItemID, newPlace, toShelf);
    }

    public Response removeItems(int ProID, List<Integer> itemsToRemove) {
        return this.inventoryService.removeItems(ProID, itemsToRemove);
    }

    public Response removeSpecificItem(int ProID, int itemID) {
        return this.inventoryService.removeSpecificItem(ProID, itemID);
    }

    public Response addItems(int ProID, int amountToAdd, int OrderID, String place, int buyPrice, Date expressionDate, String StorageShelf, boolean def) {
        return this.inventoryService.addItems(ProID, amountToAdd, OrderID, place, buyPrice, expressionDate, StorageShelf, def);
    }

    public Response changeCategory(int ProID, String newCat, String typeCat) {
        return this.inventoryService.changeCategory(ProID, newCat, typeCat);
    }

    //REPORTS
    public ResponseT<reportS> AddItemsToOrderReport(String productToOrder) {
        return this.inventoryService.AddItemsToOrderReport(productToOrder);
    }

    public ResponseT addInventoryReport(String CategoryString) {
        return this.inventoryService.addInventoryReport(CategoryString);
    }

    public ResponseT<reportS> addDefectiveReport() {
        return this.inventoryService.addDefectiveReport();
    }

    //SALES
    public Response AddSale(String StartDate, String EndDate, String Category, String Product, double Discount) {
        return this.inventoryService.AddSale(StartDate, EndDate, Category, Product, Discount);
    }

    public Response RemoveSale(int id) {
        return this.inventoryService.RemoveSale(id);
    }

    public ResponseT<Integer> SaleOnCategoryAtDate(Integer parCategory, String ThisDate) {
        return this.inventoryService.SaleOnCategoryAtDate(parCategory, ThisDate);
    }

    public ResponseT<Integer> SaleOnProductAtDate(int ProductID, String ThisDate) {
        return this.inventoryService.SaleOnProductAtDate(ProductID, ThisDate);
    }

    public ResponseT<Double> getSaleDiscount(int SaleID) {
        return this.inventoryService.getSaleDiscount(SaleID);
    }

    //Combination
    public ResponseT<Double> getPriceAfterDiscount(int productID, String date) {
        return inventoryService.getPriceAfterDiscount(productID, date);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ResponseT<Supplier> getSupplier(int id) {
        return suppliersService.getSupplier(id);
    }

    public Response placeAnOrder(int orderId) {
        return suppliersService.placeAnOrder(orderId);
    }


    public ResponseT<ServiceOrder> getOrderByOrderID(int orderId) {
        return suppliersService.getOrderByOrderID(orderId);
    }


    public Response reorder(int orderId) {
        return suppliersService.reorder(orderId);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //SUPPLIERS
    public ResponseT<Supplier> addSupplier(ServiceSupplierCard supplierCard, ServiceAgreement agreement) {
        return suppliersService.addSupplier(supplierCard, agreement);
    }

    public ResponseT<Map<String, ServiceProductS>> getSupplierItems(int supplierId) {
        return suppliersService.getSupplierItems(supplierId);
    }

    public ResponseT removeSupplier(int supplierID) {
        return suppliersService.removeSupplier(supplierID);
    }


    public Response changeSupplierPaymentMethod(int supplierId, String paymentMethode) {
        return suppliersService.changeSupplierPaymentMethod(supplierId, paymentMethode);
    }

    public Response changeSupplierBankAccount(int supplierID, String bankAccount) {
        return suppliersService.changeSupplierBankAccount(supplierID, bankAccount);
    }

    public Response editSupplierContacts(int supplierID, String name, String email, String phoneNumber, boolean editEmail) {
        return suppliersService.editSupplierContacts(supplierID, name, email, phoneNumber, editEmail);
    }

    public Response removeSupplierContact(int supplierID, String name) {
        return suppliersService.removeSupplierContact(supplierID, name);
    }

    public Response addContactsToSupplier(int supplierID, String name, String email, String phoneNumber) {
        return suppliersService.addContactsToSupplier(supplierID, name, email, phoneNumber);
    }

//    public ServiceLayer.Response addBrandsToSupplier(int supplierID, List<String> brandsName) {
//        return service.addBrandsToSupplier(supplierID, brandsName);
//    }
//
//    public ServiceLayer.Response removeBrandsFromSupplier(int supplierID, List<String> brandsName) {
//        return service.removeBrandsFromSupplier(supplierID, brandsName);
//    }
//
//
//    public ServiceLayer.Response changeOverallDiscount(int supplierID, List<String> discounts) {
//        return service.changeOverallDiscount(supplierID, discounts);
//    }


    public Response changeSupplyMethod(int supplierID, String supplyMethod, List<DayOfWeek> days) {
        return suppliersService.changeSupplyMethod(supplierID, supplyMethod, days);
    }

    public Response changeAddress(int supplierID, String address) {
        return suppliersService.changeAddress(supplierID, address);
    }

    public ResponseT addItemToAgreement(int supplierID, int productID, String priceList, String catalogNumber, List<String> discounts) {
        return suppliersService.addItemToAgreement(supplierID, productID, priceList, catalogNumber, discounts);

    }

    public ResponseT removeItemFromAgreement(int supplierID, int productID) {
        return suppliersService.removeItemFromAgreement(supplierID, productID);
    }

    public ResponseT<Boolean> isLegalSupplierID(int supplierID) {
        return suppliersService.isLegalSupplierID(supplierID);
    }

    public Response PrintAllReceivedOrders(java.sql.Date strdate) {
        try {
            return this.suppliersService.PrintAllReceivedOrders(strdate);
        } catch (Exception e) {
            return ResponseT.fromError(e.getMessage());
        }
    }

    public Response receive_Defective_Orders(java.sql.Date ThisDate, String strExp, String strDef) {
        try {
            this.suppliersService.receive_Defective_Orders(ThisDate, strExp, strDef);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public ResponseT<Boolean> isLegalOrderID(int orderId) {
        return suppliersService.isLegalOrderID(orderId);
    }

    public ResponseT<StringBuilder> createOrderReport() {
        return this.suppliersService.createOrderReport();
    }
}







