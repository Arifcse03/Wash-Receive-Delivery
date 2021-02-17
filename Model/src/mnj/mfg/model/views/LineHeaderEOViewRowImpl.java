package mnj.mfg.model.views;

import java.math.BigDecimal;

import mnj.mfg.model.entities.LineHeaderEOImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 15 15:33:30 BDT 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LineHeaderEOViewRowImpl extends ViewRowImpl {
    @Override
    public boolean isAttributeUpdateable(int i) {
        // make all attributes read-only if 'payed on date' is not null                 
        return getPocId() != null ? false : super.isAttributeUpdateable(i);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        LineId {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getLineId();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setLineId((Number)value);
            }
        }
        ,
        HeaderId {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getHeaderId();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setHeaderId((Number)value);
            }
        }
        ,
        BuyerId {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getBuyerId();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setBuyerId((Number)value);
            }
        }
        ,
        Attribute1 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getAttribute1();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttribute1((String)value);
            }
        }
        ,
        Attribute2 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getAttribute2();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttribute2((String)value);
            }
        }
        ,
        Attribute3 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getAttribute3();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttribute3((String)value);
            }
        }
        ,
        Attribute4 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getAttribute4();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttribute4((String)value);
            }
        }
        ,
        Attribute5 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getAttribute5();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttribute5((String)value);
            }
        }
        ,
        IssueToWashStatus {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getIssueToWashStatus();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setIssueToWashStatus((String)value);
            }
        }
        ,
        PocId {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getPocId();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setPocId((BigDecimal)value);
            }
        }
        ,
        LcUnit {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getLcUnit();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setLcUnit((BigDecimal)value);
            }
        }
        ,
        Season {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getSeason();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setSeason((String)value);
            }
        }
        ,
        Style {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getStyle();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setStyle((String)value);
            }
        }
        ,
        ReceiveDetailVO {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getReceiveDetailVO();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LineVO {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getLineVO();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        style1 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getstyle1();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CustomerLOV1 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getCustomerLOV1();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CustomerLov2_1 {
            public Object get(LineHeaderEOViewRowImpl obj) {
                return obj.getCustomerLov2_1();
            }

            public void put(LineHeaderEOViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(LineHeaderEOViewRowImpl object);

        public abstract void put(LineHeaderEOViewRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int LINEID = AttributesEnum.LineId.index();
    public static final int HEADERID = AttributesEnum.HeaderId.index();
    public static final int BUYERID = AttributesEnum.BuyerId.index();
    public static final int ATTRIBUTE1 = AttributesEnum.Attribute1.index();
    public static final int ATTRIBUTE2 = AttributesEnum.Attribute2.index();
    public static final int ATTRIBUTE3 = AttributesEnum.Attribute3.index();
    public static final int ATTRIBUTE4 = AttributesEnum.Attribute4.index();
    public static final int ATTRIBUTE5 = AttributesEnum.Attribute5.index();
    public static final int ISSUETOWASHSTATUS = AttributesEnum.IssueToWashStatus.index();
    public static final int POCID = AttributesEnum.PocId.index();
    public static final int LCUNIT = AttributesEnum.LcUnit.index();
    public static final int SEASON = AttributesEnum.Season.index();
    public static final int STYLE = AttributesEnum.Style.index();
    public static final int RECEIVEDETAILVO = AttributesEnum.ReceiveDetailVO.index();
    public static final int LINEVO = AttributesEnum.LineVO.index();
    public static final int STYLE1 = AttributesEnum.style1.index();
    public static final int CUSTOMERLOV1 = AttributesEnum.CustomerLOV1.index();
    public static final int CUSTOMERLOV2_1 = AttributesEnum.CustomerLov2_1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LineHeaderEOViewRowImpl() {
    }

    /**
     * Gets LineHeaderEO entity object.
     * @return the LineHeaderEO
     */
    public LineHeaderEOImpl getLineHeaderEO() {
        return (LineHeaderEOImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for LINE_ID using the alias name LineId.
     * @return the LINE_ID
     */
    public Number getLineId() {
        return (Number) getAttributeInternal(LINEID);
    }

    /**
     * Sets <code>value</code> as attribute value for LINE_ID using the alias name LineId.
     * @param value value to set the LINE_ID
     */
    public void setLineId(Number value) {
        setAttributeInternal(LINEID, value);
    }

    /**
     * Gets the attribute value for HEADER_ID using the alias name HeaderId.
     * @return the HEADER_ID
     */
    public Number getHeaderId() {
        return (Number) getAttributeInternal(HEADERID);
    }

    /**
     * Sets <code>value</code> as attribute value for HEADER_ID using the alias name HeaderId.
     * @param value value to set the HEADER_ID
     */
    public void setHeaderId(Number value) {
        setAttributeInternal(HEADERID, value);
    }

    /**
     * Gets the attribute value for BUYER_ID using the alias name BuyerId.
     * @return the BUYER_ID
     */
    public Number getBuyerId() {
        return (Number) getAttributeInternal(BUYERID);
    }

    /**
     * Sets <code>value</code> as attribute value for BUYER_ID using the alias name BuyerId.
     * @param value value to set the BUYER_ID
     */
    public void setBuyerId(Number value) {
        setAttributeInternal(BUYERID, value);
    }

    /**
     * Gets the attribute value for ATTRIBUTE1 using the alias name Attribute1.
     * @return the ATTRIBUTE1
     */
    public String getAttribute1() {
        return (String) getAttributeInternal(ATTRIBUTE1);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTRIBUTE1 using the alias name Attribute1.
     * @param value value to set the ATTRIBUTE1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**
     * Gets the attribute value for ATTRIBUTE2 using the alias name Attribute2.
     * @return the ATTRIBUTE2
     */
    public String getAttribute2() {
        return (String) getAttributeInternal(ATTRIBUTE2);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTRIBUTE2 using the alias name Attribute2.
     * @param value value to set the ATTRIBUTE2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**
     * Gets the attribute value for ATTRIBUTE3 using the alias name Attribute3.
     * @return the ATTRIBUTE3
     */
    public String getAttribute3() {
        return (String) getAttributeInternal(ATTRIBUTE3);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTRIBUTE3 using the alias name Attribute3.
     * @param value value to set the ATTRIBUTE3
     */
    public void setAttribute3(String value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**
     * Gets the attribute value for ATTRIBUTE4 using the alias name Attribute4.
     * @return the ATTRIBUTE4
     */
    public String getAttribute4() {
        return (String) getAttributeInternal(ATTRIBUTE4);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTRIBUTE4 using the alias name Attribute4.
     * @param value value to set the ATTRIBUTE4
     */
    public void setAttribute4(String value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**
     * Gets the attribute value for ATTRIBUTE5 using the alias name Attribute5.
     * @return the ATTRIBUTE5
     */
    public String getAttribute5() {
        return (String) getAttributeInternal(ATTRIBUTE5);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTRIBUTE5 using the alias name Attribute5.
     * @param value value to set the ATTRIBUTE5
     */
    public void setAttribute5(String value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**
     * Gets the attribute value for ISSUE_TO_WASH_STATUS using the alias name IssueToWashStatus.
     * @return the ISSUE_TO_WASH_STATUS
     */
    public String getIssueToWashStatus() {
        return (String) getAttributeInternal(ISSUETOWASHSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for ISSUE_TO_WASH_STATUS using the alias name IssueToWashStatus.
     * @param value value to set the ISSUE_TO_WASH_STATUS
     */
    public void setIssueToWashStatus(String value) {
        setAttributeInternal(ISSUETOWASHSTATUS, value);
    }

    /**
     * Gets the attribute value for POC_ID using the alias name PocId.
     * @return the POC_ID
     */
    public BigDecimal getPocId() {
        return (BigDecimal) getAttributeInternal(POCID);
    }

    /**
     * Sets <code>value</code> as attribute value for POC_ID using the alias name PocId.
     * @param value value to set the POC_ID
     */
    public void setPocId(BigDecimal value) {
        setAttributeInternal(POCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LcUnit.
     * @return the LcUnit
     */
    public BigDecimal getLcUnit() {
        return (BigDecimal) getAttributeInternal(LCUNIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LcUnit.
     * @param value value to set the  LcUnit
     */
    public void setLcUnit(BigDecimal value) {
        setAttributeInternal(LCUNIT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Season.
     * @return the Season
     */
    public String getSeason() {
        return (String) getAttributeInternal(SEASON);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Season.
     * @param value value to set the  Season
     */
    public void setSeason(String value) {
        setAttributeInternal(SEASON, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Style.
     * @return the Style
     */
    public String getStyle() {
        return (String) getAttributeInternal(STYLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Style.
     * @param value value to set the  Style
     */
    public void setStyle(String value) {
        setAttributeInternal(STYLE, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link ReceiveDetailVO.
     */
    public RowIterator getReceiveDetailVO() {
        return (RowIterator)getAttributeInternal(RECEIVEDETAILVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link LineVO.
     */
    public RowIterator getLineVO() {
        return (RowIterator)getAttributeInternal(LINEVO);
    }

    /**
     * Gets the view accessor <code>RowSet</code> style1.
     */
    public RowSet getstyle1() {
        return (RowSet)getAttributeInternal(STYLE1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CustomerLOV1.
     */
    public RowSet getCustomerLOV1() {
        return (RowSet)getAttributeInternal(CUSTOMERLOV1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> CustomerLov2_1.
     */
    public RowSet getCustomerLov2_1() {
        return (RowSet)getAttributeInternal(CUSTOMERLOV2_1);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}