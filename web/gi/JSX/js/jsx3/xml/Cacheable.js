/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Template","jsx3.xml.CDF");jsx3.Class.defineInterface("jsx3.xml.Cacheable",null,function(p,s){var
t=jsx3.xml.Document;var
x=jsx3.xml.CDF;var
xc=jsx3.util.Logger.getLogger(p.jsxclass.getName());p.DEFAULTSTYLESHEET=jsx3.resolveURI("jsx:///xsl/xml.xsl");p.DEFAULTXSLCACHEID="JSX_XML_XSL";p.CLEANUPRESOURCES=0;p.SHARERESOURCES=1;s.doTransform=function(h){var
cb=this.getXML();if(this.getNodeSet())cb=this.getNodeSet();var
N=this.getXSL();if(cb.hasError()||N.hasError())return "";if(h==null)h=this.jsxxslparams;var
lb="";var
K=null;if(N instanceof jsx3.xml.XslDocument){K=N;K.reset();}else K=new
jsx3.xml.Template(N);if(!K.hasError()){if(h)K.setParams(h);lb=K.transform(cb);if(K.hasError()){xc.error(jsx3._msg("xml.err_trans",this,K.getError()));lb="";}}else xc.error(jsx3._msg("xml.err_trans",this,K.getError()));return lb;};s.yp=function(e){return e.replace(/<\/?JSX_FF_WELLFORMED_WRAPPER( [^>]*)?\/?>/g,"");};s.getXSLParams=function(){if(this.jsxxslparams==null)this.jsxxslparams={};return this.jsxxslparams;};s.setXSLParam=function(q,i){if(i!=null)this.getXSLParams()[q]=i;else delete this.getXSLParams()[q];return this;};s.removeXSLParam=function(m){delete this.getXSLParams()[m];return this;};s.removeXSLParams=function(){delete this.jsxxslparams;return this;};s.getNodeSet=function(){return this._jsxbH;};s.setNodeSet=function(f){this._jsxbH=f;};s.onDestroyCached=function(a){if(this.getShareResources()==0)this.resetCacheData(a.getServer());delete this._jsxbH;};s.resetCacheData=function(j){var
Lc=(j||this.getServer()).getCache();Lc.clearById(this.getXSLId());Lc.clearById(this.getXMLId());};s.resetXmlCacheData=function(o){var
eb=(o||this.getServer()).getCache();eb.clearById(this.getXMLId());};s.resetXslCacheData=function(j){var
Mb=(j||this.getServer()).getCache();Mb.clearById(this.getXSLId());};s.clearXmlData=function(){this.getServer().getCache().setDocument(this.getXMLId(),x.newDocument());};s.getShareResources=function(){return this.jsxshare==null?0:this.jsxshare;};s.setShareResources=function(e){this.jsxshare=e;return this;};s.getXML=function(){var
gb=this.getServer();if(gb==null)return x.newDocument();var
Ec=gb.getCache().getDocument(this.getXMLId());if(Ec==null){var
Hc=this.getXMLString();if(!jsx3.util.strEmpty(Hc)){Ec=new
t();Ec.loadXML(Hc);}else{var
Ib=this.getXMLURL();if(!jsx3.util.strEmpty(Ib)){Ec=new
t();Ec.load(this.getUriResolver().resolveURI(Ib));}else Ec=x.newDocument();}if(Ec.hasError()){xc.error(jsx3._msg("xml.err_load",this,Ec.getError()));return Ec;}Ec=this.setSourceXML(Ec);}return Ec;};s.setSourceXML=function(h){h=this.QS(h);this.getServer().getCache().setDocument(this.getXMLId(),h);if(this.instanceOf(x)){if(h.getNodeName()=="data"&&h.getAttribute("jsxassignids")=="1")this.assignIds();this.convertProperties(this.getServer().getProperties());}return h;};s.getXMLId=function(){return this.jsxxmlid||this.getId()+"_XML";};s.setXMLId=function(b){this.jsxxmlid=b;return this;};s.getXMLString=function(){return this.jsxxml;};s.setXMLString=function(k){this.jsxxml=k;return this;};s.getXMLURL=function(){return this.jsxxmlurl;};s.setXMLURL=function(n){this.jsxxmlurl=n;return this;};s.getXSL=function(){return this.Mn(p.DEFAULTSTYLESHEET);};s.Mn=function(k){var
D=jsx3.xml.XslDocument;var
Lc=this.getXSLId();var
Rb=this.getServer().getCache();var
y=Rb.getDocument(Lc);if(y==null){if(this.getXSLString()!=null){y=(new
D()).loadXML(this.getXSLString());}else if(this.getXSLURL()!=null){y=(new
D()).load(this.getUriResolver().resolveURI(this.getXSLURL()));}else y=jsx3.getSharedCache().getOrOpenDocument(k,null,D.jsxclass);if(y.hasError()){xc.error(jsx3._msg("xml.err_load_xsl",this,y.getError()));return y;}Rb.setDocument(Lc,y);}return y;};s.getXSLId=function(){var
Jb=null;Jb=this.jsxxslid;return Jb||this.getId()+"_XSL";};s.setXSLId=function(r){this.jsxxslid=r;return this;};s.getXSLString=function(){return this.jsxxsl;};s.setXSLString=function(e){this.jsxxsl=e;return this;};s.getXSLURL=function(){return this.jsxxslurl;};s.setXSLURL=function(c){this.jsxxslurl=c;return this;};s.getXMLTransformers=function(){return this.jsxxmltrans!=null?this.jsxxmltrans.split(/\s*,\s*/g):[];};s.setXMLTransformers=function(a){this.jsxxmltrans=a!=null?a instanceof Array?a.join(","):a:null;};s.QS=function(r){var
nb=this.getXMLTransformers();if(nb.length>0){var
qb=this.getServer();var
pc=qb.getCache();var
I=r;for(var
u=0;u<nb.length;u++){var
Bb=nb[u];var
rb=pc.getDocument(Bb);if(rb==null){Bb=qb.resolveURI(Bb);rb=pc.openDocument(Bb,Bb);}if(rb==null||rb.hasError()){xc.warn(jsx3._msg("xml.trans_bad",Bb,this,rb.getError()));pc.clearById(Bb);continue;}var
Ac=new
jsx3.xml.Template(rb);Ac.setParams(this.getXSLParams());I=Ac.transformToObject(I);if(Ac.hasError())throw new
jsx3.Exception(jsx3._msg("xml.trans_err",Bb,this,Ac.getError()));if(I.hasError())throw new
jsx3.Exception(jsx3._msg("xml.trans_err",Bb,this,I.getError()));}return I;}else return r;};p.getVersion=function(){return "3.00.00";};});jsx3.xml.Cacheable.prototype.resetData=jsx3.xml.Cacheable.prototype.clearXmlData;
