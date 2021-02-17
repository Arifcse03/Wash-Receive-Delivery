
package mnj.mfg.view.backing_bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import mnj.mfg.model.MainAMImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.event.SelectionEvent;

public class Main {
    private RichInputText customerBuyerID;
    private RichInputText headerId;
    private RichInputListOfValues style;
    private RichTable size1st;
    private RichTable selectAllTable1;
    private RichTable size2st;
    private RichTable selectAllTable;
    private RichTable bpOTable;
    private RichInputListOfValues headerTransactionType;
    private RichPanelLabelAndMessage transaction;
    private RichInputText transactionNew;
    private RichInputText season;
    private RichTable receivingLinesTable;
    private RichTable selectAllTable0;
    private RichOutputText issueToWashStatusField;

    public Main() {
        super();
         }
    
    
//    public MainAMImpl getAppM(){
//        DCBindingContainer bindingContainer =
//            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        //BindingContext bindingContext = BindingContext.getCurrent();
//        DCDataControl dc =
//            bindingContainer.findDataControl("MainAMDataControl"); // Name of application module in datacontrolBinding.cpx
//        MainAMImpl appM = (MainAMImpl)dc.getDataProvider();
//        return appM;
//    }
//     MainAMImpl appM = getAppM();



    public void setCustomerIdS(RichInputText id) {

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        ViewObject vo = am.getLineHeaderEOView1();
             
        String buyer = "";
        try{
            buyer = vo.getCurrentRow().getAttribute("BuyerId").toString();
        }catch(Exception e){
            buyer = "";
        }
        userSession.setAttribute("CustomerIdS", buyer);
        System.out.println("Session CustomerIdS-->" + buyer);
    }

    public void setCustomerBuyerID(RichInputText customerBuyerID) {
        this.customerBuyerID = customerBuyerID;
        setCustomerIdS(customerBuyerID);


    }

    public RichInputText getCustomerBuyerID() {
        return customerBuyerID;
    }


    public void setHeaderIdS(RichInputText id) {

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("HeaderIdS", id.getValue());
    }

    public void setHeaderId(RichInputText headerId) {
        this.headerId = headerId;
        setHeaderIdS(headerId);
    }

    public RichInputText getHeaderId() {
        return headerId;
    }


    public ApplicationModule getAppM(){
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("MainAMDataControl"); // Name of application module in datacontrolBinding.cpx
        MainAMImpl appM = (MainAMImpl)dc.getDataProvider();
        return appM;
    }
    MainAMImpl am = (MainAMImpl)this.getAppM();
    
    public void setStyle(RichInputListOfValues style) {
        this.style = style;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        ViewObject vo = am.getLineHeaderEOView1();
        String sstyle = "";
        try{
            ////StyleName change korechi arif
            sstyle = vo.getCurrentRow().getAttribute("Style").toString();
        }catch(Exception e){
            sstyle = "";
        }
        userSession.setAttribute("style", sstyle);
        System.out.println("Session style-->" + sstyle);

//        if (style.getValue() != null) {
//            FacesContext context = FacesContext.getCurrentInstance();
//            FacesMessage message =
//                new FacesMessage("Production Type is set Bulk by default. Kindly change value from LOV if Production Type is different..");
//            context.addMessage(null, message);
//        } else {
//
//            System.out.println("Style is null....");
//        }
    }

    public RichInputListOfValues getStyle() {
        return style;
    }

    ////////////papulate bpo/////////


    public void editDialogListShadeBPO(DialogEvent dialogEvent) {
        System.out.println("enter editDialogListShade BPO-------------->");
        if (dialogEvent.getOutcome().name().equals("ok")) {


            OperationBinding operationBinding =
                executeOperation("FillRollLinesBPO");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(bpOTable);


        }

    }


    public void editPopupCancelListenerBPO(PopupCanceledEvent popupCanceledEvent) {

    }


    public void editPopupFetchListenerBPO(PopupFetchEvent popupFetchEvent) {

        OperationBinding operationBinding =
            executeOperation("setRollwhereClauseBPO");
        operationBinding.execute();
    }


    ////////////papulate size////////////


    public void editDialogListShade(DialogEvent dialogEvent) {
        System.out.println("enter editDialogListShade-------------->");
        if (dialogEvent.getOutcome().name().equals("ok")) {


            OperationBinding operationBinding =
                executeOperation("FillRollLines");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(size1st);


        }

    }


    public void editPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {

    }


    public void editPopupFetchListener(PopupFetchEvent popupFetchEvent) {

        OperationBinding operationBinding =
            executeOperation("setRollwhereClause");
        operationBinding.execute();
    }

    public OperationBinding executeOperation(String operation) {
        OperationBinding createParam =
            getBindingsCont().getOperationBinding(operation);
        return createParam;

    }

    /*****Generic Method to Get BindingContainer**/
    public BindingContainer getBindingsCont() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setSize1st(RichTable size1st) {
        this.size1st = size1st;
    }

    public RichTable getSize1st() {
        return size1st;
    }
    ///////////////////////////////////////////////////////////////
    ////////////papulate similar size////////////


    public void editDialogListShade1(DialogEvent dialogEvent) {
        System.out.println("enter editDialogListShade-------------->");
        if (dialogEvent.getOutcome().name().equals("ok")) {


            OperationBinding operationBinding =
                executeOperation("FillRollLines1");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(size2st);


        }

    }


    public void editPopupCancelListener1(PopupCanceledEvent popupCanceledEvent) {

    }


    public void editPopupFetchListener1(PopupFetchEvent popupFetchEvent) {

        //        OperationBinding operationBinding =
        //            executeOperation("setRollwhereClause1");
        //        operationBinding.execute();


        //        System.out.println("setSizeWhereClause");
        //        OperationBinding operationBinding = executeOperation("setSizeWhereClause");
        //        //operationBinding.getParamsMap().put("flag", "N");
        //        operationBinding.execute();
        
        
        DCBindingContainer binding =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding itorBinding =
            binding.findIteratorBinding("ReceiveDetailVO1Iterator");
        String bpo = null;
        String stn = null;
        String color = null;
        String challan_no = null;
        try {
            bpo =
               itorBinding.getCurrentRow().getAttribute("Attribute1").toString();
        } catch (Exception e) {
            ;
        }
        try {
            stn =
          itorBinding.getCurrentRow().getAttribute("Attribute2").toString();
        } catch (Exception e) {
            ;
        }
        try {
            color =
                    itorBinding.getCurrentRow().getAttribute("Attribute3").toString();
        } catch (Exception e) {
            ;
        }
        try {
            challan_no =
                    itorBinding.getCurrentRow().getAttribute("RecevingChallanNo").toString();
        } catch (Exception e) {
            ;
        }
        System.out.println("setSizeWhereClause");
        OperationBinding operationBinding =
            executeOperation("setSizeWhereClause");
        operationBinding.getParamsMap().put("bpo", bpo);
        operationBinding.getParamsMap().put("stn", stn);
        operationBinding.getParamsMap().put("color", color);
        operationBinding.getParamsMap().put("challan_no", challan_no);
        
        
        operationBinding.execute();
        
        System.out.println("=====================bpo=============="+ bpo);
        System.out.println("=====================stn=============="+ stn); 
        System.out.println("=====================color=============="+ color);
        System.out.println("=====================challan_no=============="+ challan_no);
        

    }
    ///////////////////////////////////////////////////////////////
    
    /////////////////////////FillBops select code///////////

    public void SelectAll0(ActionEvent actionEvent) {
        
        ViewObject populatevo = am.getFillBposVO1();
        populatevo.setRangeSize(50);
        //populatevo.executeQuery();

        Row[] r = populatevo.getAllRowsInRange();

        for (Row row : r) {
            System.out.println("Loop select 1");
            row.setAttribute("FlagNew", "Y");
          //  System.out.println("Get select 0---->" + row.getAttribute("FlagNew"));

        }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable0);
    }

    public void DeSelectAll0(ActionEvent actionEvent) {
        ViewObject populatevo = am.getFillBposVO1();
        populatevo.setRangeSize(50);
        //populatevo.executeQuery();

        Row[] r = populatevo.getAllRowsInRange();

        for (Row row : r) {
            System.out.println("Loop select 1");
            row.setAttribute("FlagNew", "N");
        }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable0);
    }

    /////////////////////
    
    /////////////////////////

    public void SelectAll1(ActionEvent actionEvent) {
        System.out.println("SelectAll simantaniously");
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("selectAllLines1");
        operationBinding.getParamsMap().put("flag", "Y");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable1);
        System.out.println("selectAllTable1");
    }

    public void DeSelectAll1(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("selectAllLines1");
        operationBinding.getParamsMap().put("flag", "N");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable1);
    }

    /////////////////////
    


    public void SelectAll(ActionEvent actionEvent) {
        System.out.println("SelectAll");
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllLines");
        operationBinding.getParamsMap().put("flag", "Y");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable);
        System.out.println("selectAllTable");
    }

    public void DeSelectAll(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllLines");
        operationBinding.getParamsMap().put("flag", "N");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable);
    }

    /////////////////////

    public void setSelectAllTable1(RichTable selectAllTable1) {
        this.selectAllTable1 = selectAllTable1;
    }

    public RichTable getSelectAllTable1() {

        return selectAllTable1;
    }

    public void setSize2st(RichTable size2st) {
        this.size2st = size2st;
    }

    public RichTable getSize2st() {
        return size2st;
    }

    public void setSelectAllTable(RichTable selectAllTable) {
        this.selectAllTable = selectAllTable;
    }

    public RichTable getSelectAllTable() {
        return selectAllTable;
    }

    public void setBpOTable(RichTable bpOTable) {
        this.bpOTable = bpOTable;
    }

    public RichTable getBpOTable() {
        return bpOTable;
    }

    ///////////Code To Get Total ***********************

    public double getTotalValue() {

        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContext.findDataControl("MainAMDataControl"); //
        ApplicationModule am = dc.getApplicationModule();
        ViewObject findViewObject =
            am.findViewObject("IssueInseemSizeDVO1"); //ImpSaleContractDetailEOView1

        RowSetIterator it = findViewObject.createRowSetIterator("tt");
        double val = 0.0, total = 0.0;
        while (it.hasNext()) {

            Row r = it.next();
            try {
                val =
Double.parseDouble(r.getAttribute("Quantity").toString());
            } catch (Exception e) {
                ;
            }

            total = total + val;
        } //end of while loop
        it.closeRowSetIterator();
        return total;
    }

    /// Code to Set Total

    public void setLineValueTotal(double val) {

        oracle.adf.view.rich.component.UIXTable table = getBpOTable();
        // Get the Selected Row key set iterator
        java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
        double ply = 0.0;
        while (selectionIt.hasNext()) {
            Object rowKey = selectionIt.next();
            table.setRowKey(rowKey);
            int index = table.getRowIndex();
            FacesCtrlHierNodeBinding row =
                (FacesCtrlHierNodeBinding)table.getRowData(index);
            Row selectedRow = row.getRow();


            selectedRow.setAttribute("Quantity", val);


        }

    }
    /////////////////////////////////////


    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String Save() {

        ViewObject vold = am.getIssueInseemSizeDVO1();
        
        if (vold.getRowCount() > 0) {
            setLineValueTotal(getTotalValue());
        } else {    
            System.out.println("Size Data is null...");
            ;
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(bpOTable);
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }

        //valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        DCBindingContainer binding =
//            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//        DCIteratorBinding itorBinding =
//            binding.findIteratorBinding("ReciveSizeInseemVO1Iterator");
//        RowSetIterator rowSetIterator = itorBinding.getRowSetIterator();
        
        ViewObject itorBinding = am.findViewObject("ReciveSizeInseemVO1");       
        RowSetIterator rowSetIterator = itorBinding.createRowSetIterator("tt");
        
        int Quantity = 0;
        while (rowSetIterator.hasNext())
        {
            
            Row row = rowSetIterator.next();
            
            System.out.println("Sabih Quantity " + Quantity);
            
            Quantity =
                    Integer.parseInt(row.getAttribute("Quantity").toString()) +
                    Quantity;
            
        }
        rowSetIterator.closeRowSetIterator();
        System.out.println("Quantity " + Quantity);

        DCBindingContainer binding1 =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding itorBinding1 =
            binding1.findIteratorBinding("ReceiveDetailVO1Iterator");
        if (Quantity != 0)
            itorBinding1.getCurrentRow().setAttribute("Attribute4", Quantity);
        AdfFacesContext.getCurrentInstance().addPartialTarget(receivingLinesTable);
        binding1.getOperationBinding("Commit").execute();
         
         
       //  am.getHeaderVO1().executeQuery();
         refreshQueryKeepingCurrentRow(am.getHeaderVO1());
        return null;
    }

    public void setHeaderTransactionType(RichInputListOfValues headerTransactionType) {
        this.headerTransactionType = headerTransactionType;
    }

    public RichInputListOfValues getHeaderTransactionType() {
        return headerTransactionType;
    }

    public void setTransaction(RichPanelLabelAndMessage transaction) {
        this.transaction = transaction;

    }

    public RichPanelLabelAndMessage getTransaction() {
        return transaction;
    }

    public void setTransaction(RichInputText id) {

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("Transaction", id.getValue());
        System.out.println("Session Transaction -->" + id.getValue());
    }


    public void setTransactionNew(RichInputText transactionNew) {
        this.transactionNew = transactionNew;

        setTransaction(transactionNew);

    }

    public RichInputText getTransactionNew() {
        return transactionNew;
    }

    public void setSeason(RichInputText season) {
        this.season = season;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        
        ViewObject vo = am.getLineHeaderEOView1();
        String ssn = "";
        try{
            ssn = vo.getCurrentRow().getAttribute("Season").toString();
        }catch(Exception e){
            ssn = "";
        }
        userSession.setAttribute("season", ssn);
        System.out.println("Session season-->" + ssn);
    }

    public RichInputText getSeason() {
        return season;
    }

    public String setSizeWhereClause() {
        // Add event code here...
        //        System.out.println("setSizeWhereClause");
        //        OperationBinding operationBinding = executeOperation("setSizeWhereClause");
        //        //operationBinding.getParamsMap().put("flag", "N");
        //        operationBinding.execute();
        return null;
    }

    public void linesSelectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        makeCurrent(selectionEvent);
        //        DCBindingContainer binding = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //        DCIteratorBinding itorBinding = binding.findIteratorBinding("ReceiveDetailVO1Iterator");
        //        String bpo = null;
        //        String stn = null;
        //        String color = null;
        //        try
        //        {
        //            bpo = itorBinding.getCurrentRow().getAttribute("Attribute1").toString();
        //        }catch(Exception e){
        //            ;
        //        }
        //        try
        //        {
        //            stn = itorBinding.getCurrentRow().getAttribute("Attribute2").toString();
        //        }catch(Exception e){
        //            ;
        //        }
        //        try
        //        {
        //            color = itorBinding.getCurrentRow().getAttribute("Attribute3").toString();
        //        }catch(Exception e){
        //            ;
        //        }
        //
        //        System.out.println("setSizeWhereClause");
        //        OperationBinding operationBinding = executeOperation("setSizeWhereClause");
        //        operationBinding.getParamsMap().put("bpo", bpo);
        //        operationBinding.getParamsMap().put("stn", stn);
        //        operationBinding.getParamsMap().put("color",color);
        //        operationBinding.execute();


    }


    public static void makeCurrent(org.apache.myfaces.trinidad.event.SelectionEvent selectionEvent) {
        RichTable _table = (RichTable)selectionEvent.getSource();
        //the Collection Model is the object that provides the
        //structured data for the table to render
        org.apache.myfaces.trinidad.model.CollectionModel _tableModel =
            (org.apache.myfaces.trinidad.model.CollectionModel)_table.getValue();
        //the ADF object that implements the CollectionModel is  JUCtrlHierBinding. It is wrapped by the CollectionModel API
        oracle.jbo.uicli.binding.JUCtrlHierBinding _adfTableBinding =
            (oracle.jbo.uicli.binding.JUCtrlHierBinding)_tableModel.getWrappedData();
        //Acess the ADF iterator binding that is used with ADF table binding
        oracle.adf.model.binding.DCIteratorBinding _tableIteratorBinding =
            _adfTableBinding.getDCIteratorBinding();
        //the role of this method is to synchronize the table component selection with the selection in the ADF model
        Object _selectedRowData = _table.getSelectedRowData();
        //cast to JUCtrlHierNodeBinding, which is the ADF object that represents a row
        oracle.jbo.uicli.binding.JUCtrlHierNodeBinding _nodeBinding =
            (oracle.jbo.uicli.binding.JUCtrlHierNodeBinding)_selectedRowData;
        oracle.jbo.Key _rwKey = _nodeBinding.getRowKey();
        _tableIteratorBinding.setCurrentRowWithKey(_rwKey.toStringFormat(true));
    }

    public void receiveSizeQtyValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        DCBindingContainer binding =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding itorBinding =
            binding.findIteratorBinding("ReciveSizeInseemVO1Iterator");
        RowSetIterator rowSetIterator = itorBinding.getRowSetIterator();
        double Quantity = 0.00;
        while (rowSetIterator.hasNext()) {
            Row row = rowSetIterator.next();
            Quantity =
                    Double.parseDouble(row.getAttribute("Quantity").toString()) +
                    Quantity;
        }
        rowSetIterator.closeRowSetIterator();


        //String Quantity = valueChangeEvent.getNewValue().toString();
        System.out.println("Quantity " + Quantity);
        //OperationBinding operationBinding = executeOperation("receiveSizeQtyValueChangeListener");
        //operationBinding.getParamsMap().put("Quantity",Quantity);
        //operationBinding.execute();
    }

    public void setReceivingLinesTable(RichTable receivingLinesTable) {
        this.receivingLinesTable = receivingLinesTable;
    }

    public RichTable getReceivingLinesTable() {
        return receivingLinesTable;
    }

    public void setSelectAllTable0(RichTable selectAllTable0) {
        this.selectAllTable0 = selectAllTable0;
    }

    public RichTable getSelectAllTable0() {
        return selectAllTable0;
    }

    public void issueToWash(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject headerVo = am.getHeaderVO1();
        headerVo.getCurrentRow().setAttribute("IssueToWashStatus", "Issued");
        AdfFacesContext.getCurrentInstance().addPartialTarget(issueToWashStatusField);
        
        
        Save();
    }

    public void setIssueToWashStatusField(RichOutputText issueToWashStatusField) {
        this.issueToWashStatusField = issueToWashStatusField;
    }

    public RichOutputText getIssueToWashStatusField() {
        return issueToWashStatusField;
    }

    private void refreshQueryKeepingCurrentRow(ViewObject viewObject) {
        
        Row currentRow;
        Key currentRowKey;
        
        // added on 7.jan.18 to handle exception if view object has no current row
        try{
          currentRow = viewObject.getCurrentRow();
          currentRowKey = currentRow.getKey();
        }
        catch(Exception e){
           return;
        }
        
        int rangePosOfCurrentRow = viewObject.getRangeIndexOf(currentRow);
        int rangeStartBeforeQuery = viewObject.getRangeStart();
        viewObject.executeQuery();
        viewObject.setRangeStart(rangeStartBeforeQuery);
        /*
        * In 10.1.2, there is this convenience method we could use
        * instead of the remaining lines of code
        *
        *  findAndSetCurrentRowByKey(currentRowKey,rangePosOfCurrentRow);
        *
        */
        
        Row[] rows = viewObject.findByKey(currentRowKey, 1);
        if (rows != null && rows.length == 1)
        {
         viewObject.scrollRangeTo(rows[0], rangePosOfCurrentRow);
         viewObject.setCurrentRowAtRangeIndex(viewObject.getRangeIndexOf(rows[0]));
        }
        
    }
}
