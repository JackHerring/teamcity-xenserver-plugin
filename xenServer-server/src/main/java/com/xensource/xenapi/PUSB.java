/*
 * Copyright (c) Citrix Systems, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   1) Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *
 *   2) Redistributions in binary form must reproduce the above
 *      copyright notice, this list of conditions and the following
 *      disclaimer in the documentation and/or other materials
 *      provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package com.xensource.xenapi;

import com.xensource.xenapi.Types.BadServerResponse;
import com.xensource.xenapi.Types.VersionException;
import com.xensource.xenapi.Types.XenAPIException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.xmlrpc.XmlRpcException;

/**
 * A physical USB device
 * First published in XenServer 7.3.
 *
 * @author Citrix Systems, Inc.
 */
public class PUSB extends XenAPIObject {

    /**
     * The XenAPI reference (OpaqueRef) to this object.
     */
    protected final String ref;

    /**
     * For internal use only.
     */
    PUSB(String ref) {
       this.ref = ref;
    }

    /**
     * @return The XenAPI reference (OpaqueRef) to this object.
     */
    public String toWireString() {
       return this.ref;
    }

    /**
     * If obj is a PUSB, compares XenAPI references for equality.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj != null && obj instanceof PUSB)
        {
            PUSB other = (PUSB) obj;
            return other.ref.equals(this.ref);
        } else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return ref.hashCode();
    }

    /**
     * Represents all the fields in a PUSB
     */
    public static class Record implements Types.Record {
        public String toString() {
            StringWriter writer = new StringWriter();
            PrintWriter print = new PrintWriter(writer);
            print.printf("%1$20s: %2$s\n", "uuid", this.uuid);
            print.printf("%1$20s: %2$s\n", "USBGroup", this.USBGroup);
            print.printf("%1$20s: %2$s\n", "host", this.host);
            print.printf("%1$20s: %2$s\n", "path", this.path);
            print.printf("%1$20s: %2$s\n", "vendorId", this.vendorId);
            print.printf("%1$20s: %2$s\n", "vendorDesc", this.vendorDesc);
            print.printf("%1$20s: %2$s\n", "productId", this.productId);
            print.printf("%1$20s: %2$s\n", "productDesc", this.productDesc);
            print.printf("%1$20s: %2$s\n", "serial", this.serial);
            print.printf("%1$20s: %2$s\n", "version", this.version);
            print.printf("%1$20s: %2$s\n", "description", this.description);
            print.printf("%1$20s: %2$s\n", "passthroughEnabled", this.passthroughEnabled);
            print.printf("%1$20s: %2$s\n", "otherConfig", this.otherConfig);
            return writer.toString();
        }

        /**
         * Convert a PUSB.Record to a Map
         */
        public Map<String,Object> toMap() {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("uuid", this.uuid == null ? "" : this.uuid);
            map.put("USB_group", this.USBGroup == null ? new USBGroup("OpaqueRef:NULL") : this.USBGroup);
            map.put("host", this.host == null ? new Host("OpaqueRef:NULL") : this.host);
            map.put("path", this.path == null ? "" : this.path);
            map.put("vendor_id", this.vendorId == null ? "" : this.vendorId);
            map.put("vendor_desc", this.vendorDesc == null ? "" : this.vendorDesc);
            map.put("product_id", this.productId == null ? "" : this.productId);
            map.put("product_desc", this.productDesc == null ? "" : this.productDesc);
            map.put("serial", this.serial == null ? "" : this.serial);
            map.put("version", this.version == null ? "" : this.version);
            map.put("description", this.description == null ? "" : this.description);
            map.put("passthrough_enabled", this.passthroughEnabled == null ? false : this.passthroughEnabled);
            map.put("other_config", this.otherConfig == null ? new HashMap<String, String>() : this.otherConfig);
            return map;
        }

        /**
         * Unique identifier/object reference
         */
        public String uuid;
        /**
         * USB group the PUSB is contained in
         */
        public USBGroup USBGroup;
        /**
         * Physical machine that owns the USB device
         */
        public Host host;
        /**
         * port path of USB device
         */
        public String path;
        /**
         * vendor id of the USB device
         */
        public String vendorId;
        /**
         * vendor description of the USB device
         */
        public String vendorDesc;
        /**
         * product id of the USB device
         */
        public String productId;
        /**
         * product description of the USB device
         */
        public String productDesc;
        /**
         * serial of the USB device
         */
        public String serial;
        /**
         * USB device version
         */
        public String version;
        /**
         * USB device description
         */
        public String description;
        /**
         * enabled for passthrough
         */
        public Boolean passthroughEnabled;
        /**
         * additional configuration
         */
        public Map<String, String> otherConfig;
    }

    /**
     * Get a record containing the current state of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return all fields from the object
     */
    public PUSB.Record getRecord(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_record";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toPUSBRecord(result);
    }

    /**
     * Get a reference to the PUSB instance with the specified UUID.
     * First published in XenServer 7.3.
     *
     * @param uuid UUID of object to return
     * @return reference to the object
     */
    public static PUSB getByUuid(Connection c, String uuid) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_by_uuid";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(uuid)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toPUSB(result);
    }

    /**
     * Get the uuid field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getUuid(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_uuid";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the USB_group field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public USBGroup getUSBGroup(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_USB_group";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toUSBGroup(result);
    }

    /**
     * Get the host field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public Host getHost(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_host";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toHost(result);
    }

    /**
     * Get the path field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getPath(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_path";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the vendor_id field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getVendorId(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_vendor_id";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the vendor_desc field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getVendorDesc(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_vendor_desc";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the product_id field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getProductId(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_product_id";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the product_desc field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getProductDesc(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_product_desc";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the serial field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getSerial(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_serial";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the version field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getVersion(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_version";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the description field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public String getDescription(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_description";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toString(result);
    }

    /**
     * Get the passthrough_enabled field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public Boolean getPassthroughEnabled(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_passthrough_enabled";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toBoolean(result);
    }

    /**
     * Get the other_config field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @return value of the field
     */
    public Map<String, String> getOtherConfig(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_other_config";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toMapOfStringString(result);
    }

    /**
     * Set the other_config field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @param otherConfig New value to set
     */
    public void setOtherConfig(Connection c, Map<String, String> otherConfig) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.set_other_config";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(otherConfig)};
        Map response = c.dispatch(method_call, method_params);
        return;
    }

    /**
     * Add the given key-value pair to the other_config field of the given PUSB.
     * First published in XenServer 7.3.
     *
     * @param key Key to add
     * @param value Value to add
     */
    public void addToOtherConfig(Connection c, String key, String value) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.add_to_other_config";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(key), Marshalling.toXMLRPC(value)};
        Map response = c.dispatch(method_call, method_params);
        return;
    }

    /**
     * Remove the given key and its corresponding value from the other_config field of the given PUSB.  If the key is not in that Map, then do nothing.
     * First published in XenServer 7.3.
     *
     * @param key Key to remove
     */
    public void removeFromOtherConfig(Connection c, String key) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.remove_from_other_config";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(key)};
        Map response = c.dispatch(method_call, method_params);
        return;
    }

    /**
     * 
     * First published in XenServer 7.3.
     *
     * @param host The host
     * @return Task
     */
    public static Task scanAsync(Connection c, Host host) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "Async.PUSB.scan";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(host)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
        return Types.toTask(result);
    }

    /**
     * 
     * First published in XenServer 7.3.
     *
     * @param host The host
     */
    public static void scan(Connection c, Host host) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.scan";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(host)};
        Map response = c.dispatch(method_call, method_params);
        return;
    }

    /**
     * 
     * First published in XenServer 7.3.
     *
     * @param value passthrough is enabled when true and disabled with false
     * @return Task
     */
    public Task setPassthroughEnabledAsync(Connection c, Boolean value) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "Async.PUSB.set_passthrough_enabled";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(value)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
        return Types.toTask(result);
    }

    /**
     * 
     * First published in XenServer 7.3.
     *
     * @param value passthrough is enabled when true and disabled with false
     */
    public void setPassthroughEnabled(Connection c, Boolean value) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.set_passthrough_enabled";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(value)};
        Map response = c.dispatch(method_call, method_params);
        return;
    }

    /**
     * Return a list of all the PUSBs known to the system.
     * First published in XenServer 7.3.
     *
     * @return references to all objects
     */
    public static Set<PUSB> getAll(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_all";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toSetOfPUSB(result);
    }

    /**
     * Return a map of PUSB references to PUSB records for all PUSBs known to the system.
     * First published in XenServer 7.3.
     *
     * @return records of all objects
     */
    public static Map<PUSB, PUSB.Record> getAllRecords(Connection c) throws
       BadServerResponse,
       XenAPIException,
       XmlRpcException {
        String method_call = "PUSB.get_all_records";
        String session = c.getSessionReference();
        Object[] method_params = {Marshalling.toXMLRPC(session)};
        Map response = c.dispatch(method_call, method_params);
        Object result = response.get("Value");
            return Types.toMapOfPUSBPUSBRecord(result);
    }

}