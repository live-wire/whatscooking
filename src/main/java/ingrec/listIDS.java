/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ingrec;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-5-12")
public class listIDS implements org.apache.thrift.TBase<listIDS, listIDS._Fields>, java.io.Serializable, Cloneable, Comparable<listIDS> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("listIDS");

  private static final org.apache.thrift.protocol.TField RECIPE_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("recipeIDs", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new listIDSStandardSchemeFactory());
    schemes.put(TupleScheme.class, new listIDSTupleSchemeFactory());
  }

  public List<Integer> recipeIDs; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RECIPE_IDS((short)1, "recipeIDs");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RECIPE_IDS
          return RECIPE_IDS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RECIPE_IDS, new org.apache.thrift.meta_data.FieldMetaData("recipeIDs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(listIDS.class, metaDataMap);
  }

  public listIDS() {
  }

  public listIDS(
    List<Integer> recipeIDs)
  {
    this();
    this.recipeIDs = recipeIDs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public listIDS(listIDS other) {
    if (other.isSetRecipeIDs()) {
      List<Integer> __this__recipeIDs = new ArrayList<Integer>(other.recipeIDs);
      this.recipeIDs = __this__recipeIDs;
    }
  }

  public listIDS deepCopy() {
    return new listIDS(this);
  }

  @Override
  public void clear() {
    this.recipeIDs = null;
  }

  public int getRecipeIDsSize() {
    return (this.recipeIDs == null) ? 0 : this.recipeIDs.size();
  }

  public java.util.Iterator<Integer> getRecipeIDsIterator() {
    return (this.recipeIDs == null) ? null : this.recipeIDs.iterator();
  }

  public void addToRecipeIDs(int elem) {
    if (this.recipeIDs == null) {
      this.recipeIDs = new ArrayList<Integer>();
    }
    this.recipeIDs.add(elem);
  }

  public List<Integer> getRecipeIDs() {
    return this.recipeIDs;
  }

  public listIDS setRecipeIDs(List<Integer> recipeIDs) {
    this.recipeIDs = recipeIDs;
    return this;
  }

  public void unsetRecipeIDs() {
    this.recipeIDs = null;
  }

  /** Returns true if field recipeIDs is set (has been assigned a value) and false otherwise */
  public boolean isSetRecipeIDs() {
    return this.recipeIDs != null;
  }

  public void setRecipeIDsIsSet(boolean value) {
    if (!value) {
      this.recipeIDs = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RECIPE_IDS:
      if (value == null) {
        unsetRecipeIDs();
      } else {
        setRecipeIDs((List<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RECIPE_IDS:
      return getRecipeIDs();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RECIPE_IDS:
      return isSetRecipeIDs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof listIDS)
      return this.equals((listIDS)that);
    return false;
  }

  public boolean equals(listIDS that) {
    if (that == null)
      return false;

    boolean this_present_recipeIDs = true && this.isSetRecipeIDs();
    boolean that_present_recipeIDs = true && that.isSetRecipeIDs();
    if (this_present_recipeIDs || that_present_recipeIDs) {
      if (!(this_present_recipeIDs && that_present_recipeIDs))
        return false;
      if (!this.recipeIDs.equals(that.recipeIDs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_recipeIDs = true && (isSetRecipeIDs());
    list.add(present_recipeIDs);
    if (present_recipeIDs)
      list.add(recipeIDs);

    return list.hashCode();
  }

  @Override
  public int compareTo(listIDS other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRecipeIDs()).compareTo(other.isSetRecipeIDs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecipeIDs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recipeIDs, other.recipeIDs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("listIDS(");
    boolean first = true;

    sb.append("recipeIDs:");
    if (this.recipeIDs == null) {
      sb.append("null");
    } else {
      sb.append(this.recipeIDs);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class listIDSStandardSchemeFactory implements SchemeFactory {
    public listIDSStandardScheme getScheme() {
      return new listIDSStandardScheme();
    }
  }

  private static class listIDSStandardScheme extends StandardScheme<listIDS> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, listIDS struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RECIPE_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.recipeIDs = new ArrayList<Integer>(_list0.size);
                int _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI32();
                  struct.recipeIDs.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setRecipeIDsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, listIDS struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.recipeIDs != null) {
        oprot.writeFieldBegin(RECIPE_IDS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.recipeIDs.size()));
          for (int _iter3 : struct.recipeIDs)
          {
            oprot.writeI32(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class listIDSTupleSchemeFactory implements SchemeFactory {
    public listIDSTupleScheme getScheme() {
      return new listIDSTupleScheme();
    }
  }

  private static class listIDSTupleScheme extends TupleScheme<listIDS> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, listIDS struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRecipeIDs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetRecipeIDs()) {
        {
          oprot.writeI32(struct.recipeIDs.size());
          for (int _iter4 : struct.recipeIDs)
          {
            oprot.writeI32(_iter4);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, listIDS struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.recipeIDs = new ArrayList<Integer>(_list5.size);
          int _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = iprot.readI32();
            struct.recipeIDs.add(_elem6);
          }
        }
        struct.setRecipeIDsIsSet(true);
      }
    }
  }

}
