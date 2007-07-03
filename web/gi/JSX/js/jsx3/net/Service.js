/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.Class.defineClass("jsx3.net.Service",null,[jsx3.util.EventDispatcher],function(c,g){c.simpletypes={};c.simpletypestext="Lorem ipsum dolor sit amet consectetuer adipiscing elit In pharetra wisi non dolor Pellentesque a ipsum Nulla laoreet erat a nulla In porta luctus justo Pellentesque arcu odio sollicitudin ac hendrerit non ornare et risus Proin aliquam viverra ligula Aliquam eget lectus eu lorem convallis volutpat Aliquam erat volutpat";c.simpletypes["string"]=function(){var
zc=parseInt(Math.random()*(c.simpletypestext.length-15));return jsx3.util.strTrim(c.simpletypestext.substring(zc,zc+15));};c.simpletypes["int"]="1000";c.simpletypes["integer"]="2000";c.simpletypes["double"]="1.234";c.simpletypes["boolean"]="true";c.simpletypes["date"]="2005-10-19Z";c.simpletypes["time"]="22:33:12Z";c.simpletypes["short"]="1";c.simpletypes["unsignedLong"]="26216842";c.simpletypes["unsignedInt"]="10";c.simpletypes["unsignedShort"]="1";c.simpletypes["unsignedByte"]="10";c.simpletypes["byte"]="10";c.simpletypes["long"]="48216842";c.simpletypes["decimal"]="1.00";c.simpletypes["positiveInteger"]="100";c.simpletypes["negativeInteger"]="-30";c.simpletypes["nonPositiveInteger"]="-40";c.simpletypes["nonNegativeInteger"]="10";c.simpletypes["nonPositiveInteger"]="-10";c.simpletypes["duration"]="1696-09-01T00:00:00";c.simpletypes["dateTime"]="10-25-2004T11:34:01";c.simpletypes["gYear"]="2005";c.simpletypes["date"]="10-25-2004";c.simpletypes["gMonthDay"]="12-25";c.simpletypes["gDay"]="25";c.simpletypes["gMonth"]="12";c.simpletypes["gYearMonth"]="2004-12";c.simpletypes["base64Binary"]="bGJpcmRlYXVAdGliY28uY29t";c.simpletypes["float"]="134.52";c.simpletypes["decimal"]="0.923874";c.simpletypes["anyURI"]="http://www.tibco.com/jsx/";c.simpletypes["NMTOKEN"]="Y";c.simpletypes["NMTOKENS"]="NO";c.simpletypes["Name"]="abc";c.simpletypes["NCName"]="abcdefg";c.simpletypes["token"]="Y";c.simpletypes["language"]="en-cockney";c.simpletypes["normalizedString"]=c.simpletypes["string"];c.simpletypes["ID"]="ID";c.simpletypes["IDREFS"]="IDREFS";c.simpletypes["ENTITY"]="ENTITY";c.simpletypes["ENTITIES"]="ENTITIES";c.simpletypes["QName"]="qname";c.simpletypes["hexBinary"]="\\u255\\u254";c.simpletypes["notation"]="here is a note";c.inc_inc=0;c.ns={};c.ns["SOAP-ENV"]="http://schemas.xmlsoap.org/soap/envelope/";c.ns["SOAP-ENC"]="http://schemas.xmlsoap.org/soap/encoding/";c.ns["xsi"]="http://www.w3.org/2001/XMLSchema-instance";c.ns["xsd"]="http://www.w3.org/2001/XMLSchema";c.ON_SUCCESS="onSuccess";c.ON_ERROR="onError";c.ON_TIMEOUT="onTimeout";c.ON_INVALID="onInvalid";c.ON_PROCESS_RULE="onProcessRule";g.init=function(h,e,r,j){this.setRulesURL(h);this.setOperationName(e);if(r!=null)this.setOutboundURL(r);if(j!=null)this.setInboundURL(j);var
X=new
jsx3.net.Request(this.getUniqueId());X.subscribe(jsx3.HttpRequest.EVENT_ON_RESPONSE,this,"onResponse");this.setRequest(X);};g.getSupportedNamespaces=function(){var
nc="";for(var pb in c.ns)nc=nc+(pb+"\t:\t"+c.ns[pb]+"\r\n");return nc;};g.getRulesURL=function(){return this.jsxrulesurl;};g.setRulesURL=function(r){this.jsxrulesurl=r;this.resetRulesTree();return this;};g._getOutboundStubDocument=function(){if(this.jsxstubdocument instanceof jsx3.xml.Document)return this.jsxstubdocument;};g.setOutboundStubDocument=function(p){this.jsxstubdocument=p;return this;};g.getOutboundStubURL=function(){if(this.jsxstuburl==null){var
nb=this.getMEPNode("I");if(nb){var
D=nb.getAttribute("stubsrc");return D!=null&&jsx3.util.strTrim(D)!=""?D:null;}}else return this.jsxstuburl;};g.setOutboundStubURL=function(d){this.jsxstuburl=d;return this;};g.getNamespace=function(){var
P=this.getServer();return P!=null?P.getEnv("namespace"):null;};g.getServer=function(){if(this._jsxgm){return this._jsxgm;}else if(this.jsxserverns){var
kb=jsx3.lang.System.getApp(this.jsxserverns);if(kb instanceof jsx3.app.Server){return kb;}else c.ev(2,"The server namespace referenced by this jsx3.net.Service instance could not be resolved. Please validate that the namespace is correct: "+this.jsxserverns);}else{var
cb=jsx3.System.getAllApps();for(var
_=0;_<cb.length;_++)if(cb[_].getEnv("namespace")!="jsx3.IDE")return cb[_];}if(jsx3.IDE){c.ev(2,"When using the XML Mapping Utility, you must have at lease one GUI component open for edit within GI Builder. Otherwise, there is no server instance to to use as the server context. For now, the IDE context will be used.");return jsx3.IDE;}};g.setNamespace=function(h){if(h instanceof jsx3.app.Server){this._jsxgm=h;this.jsxserverns=h.getEnv("namespace");}else{this._jsxgm=null;this.jsxserverns=h;}return this;};g.getOutboundStubPath=function(){if(this.jsxstubpath==null){var
V=this.getMEPNode("I");if(V){var
Zb=V.getAttribute("stubpath");return Zb!=null&&jsx3.util.strTrim(Zb)!=""?Zb:null;}}else return this.jsxstubpath;};g.setOutboundStubPath=function(r){this.jsxstubpath=r;return this;};g.getInboundURL=function(){if(this.jsxinboundurl==null){var
jc=this.getMEPNode("O");if(jc){var
C=jc.getAttribute("stubsrc");return C!=null&&jsx3.util.strTrim(C)!=""?C:null;}}else return this.jsxinboundurl;};g.setInboundURL=function(o){this.jsxinboundurl=o;return this;};g.getOutboundURL=function(){return this.jsxoutboundurl;};g.setOutboundURL=function(l){this.jsxoutboundurl=l;return this;};g.getOperationName=function(){return this.operation;};g.setOperationName=function(f){this.operation=f;return this;};g.getRulesXML=function(){if(!this.jsxrulesxml){var
H=this.getRulesURL();var
D=new
jsx3.xml.Document();D.load(H);if(D.hasError()){c.ev(2,"The URL for the rules file does not reference a valid CXF document. Please make sure that the URL is correct ("+H+") and that it returns a valid document:\n\t"+D.getError());}else this.jsxrulesxml=D;}return this.jsxrulesxml;};g.setRulesXML=function(a){this.jsxrulesxml=a;};g.resetRulesTree=function(){delete this.jsxrulesxml;return this;};g.getOperationNode=function(){var
ab=this.getRulesXML();if(ab){var
Lb=ab.selectSingleNode("//record[@opname='"+this.getOperationName()+"']");return Lb?Lb:this.getRulesXML().selectSingleNode("//record[@type='T']");}};g.getMEPNode=function(d){var
Bb=this.getOperationNode();return Bb?Bb.selectSingleNode("record[@type='"+d+"']"):null;};g.getUserName=function(){return this.jsxusername;};g.setUserName=function(b){this.jsxusername=b;return this;};g.getUserPass=function(){return this.jsxuserpass;};g.setUserPass=function(p){this.jsxuserpass=p;return this;};g.setOnSuccess=function(n){this.jsxonsuccess=n;return this;};g.setOnError=function(h){this.jsxonerror=h;return this;};g.onSuccess=function(){this.publish({subject:"onSuccess"});var
yb=typeof this.jsxonsuccess;if(yb=="function"||yb=="object"){this.jsxonsuccess(this);}else if(yb=="string")this.eval(this.jsxonsuccess);};g.onError=function(){this.publish({subject:"onError"});var
zb=typeof this.jsxonerror;if(zb=="function"||zb=="object"){this.jsxonerror(this);}else if(zb=="string")this.eval(this.jsxonerror);};g.setRequest=function(p){if(p!=null){this.jsxhttprequest=p;}else delete this.jsxhttprequest;};g.getRequest=function(){return this.jsxhttprequest;};g.getInboundDocument=function(){return this.jsxinbounddocument==null?null:this.jsxinbounddocument;};g.setInboundDocument=function(l){this.jsxinbounddocument=l;};g.getOutboundDocument=function(){return this.jsxoutbounddocument==null?null:this.jsxoutbounddocument;};g.setOutboundDocument=function(i){this.jsxoutbounddocument=i;};g.getWSDL=function(){if(this.wsdl==null){var
ec=this.getRulesXML().selectSingleNode("//record[@type='W']");if(ec){var
V=ec.getAttribute("src");}else return;}return this.wsdl==null?this.wsdl=jsx3.CACHE.openDocument(V):this.wsdl;};g.getEndpointURL=function(){return this.jsxserviceurl==null?this.getOperationNode().getAttribute("endpoint"):this.jsxserviceurl;};g.setEndpointURL=function(h){this.jsxserviceurl=h;return this;};g.doOutboundFilter=function(f){c.ev(5,"Executing the Outbound Filter.");if(f==null)f=this.getMEPNode("I").getAttribute("onbeforesend");this.eval(f);};g.doInboundFilter=function(k){c.ev(5,"Executing the Inbound Filter.");if(k==null){var
R=this.getMEPNode("O");if(R){k=R.getAttribute("onafterreceive");}else{c.ev(5,"An alternate message exchange pattern was encountered for the mapping rule: one-way. The inbound filter will not be run.");return;}}this.eval(k);};g.getMethod=function(){if(this.jsxmethod==null){var
Gb=this.getOperationNode().getAttribute("method");if(jsx3.util.strEmpty(Gb))Gb="POST";this.jsxmethod=Gb;}return this.jsxmethod;};g.setMethod=function(i){this.jsxmethod=i;};g._setValid=function(d){this.AD=d;};g._isValid=function(){return this.AD;};g.doCall=function(o){var
Bc=this.getRulesXML();if(Bc!=null)if(!this.getMode()){var
I=this.getServer().resolveURI(this.getInboundURL());c.ev(5,"Running in static mode. Using sample response document at '"+I+"'");var
qc=this.getServer().getCache().getOrOpenDocument(I,I);if(qc.hasError()){c.ev(2,"The static response URL does not reference a valid document. The transaction has been cancelled.  Please make sure that the URL is correct ("+I+") and that it returns a valid document:\n\t"+qc.getError());}else{qc=qc.cloneDocument();jsx3.sleep(function(){this.onResponse({target:{getResponseXML:function(){return qc;}}});},null,this);}}else{var
lc=this.getOutboundURL();var
Mb;if(lc){lc=this.getServer().resolveURI(lc);c.ev(5,"Using static request document located at '"+lc+"'");Mb=this.getServer().getCache().getOrOpenDocument(lc,lc);if(Mb.hasError()){c.ev(2,"The static request URL does not reference a valid document. The transaction has been cancelled.  Please make sure that the URL is correct ("+lc+") and that it returns a valid document:\n\t"+Mb.getError());return;}else Mb=Mb.cloneDocument();}else{Mb=this.getServiceMessage();if(this.getMethod().toUpperCase()=="POST"&&!Mb){c.ev(4,"The request message could not be generated. The transaction has been cancelled");return;}}if(!this._isValid()&&o){return false;}else{this.setOutboundDocument(Mb);this.doOutboundFilter();c.ev(5,"Sending request to remote service located at '"+this.getEndpointURL()+"'");var
db=this.getRequest();db.open(this.getMethod(),this.getEndpointURL(),true,this.getUserName(),this.getUserPass());var
kc=this.getHeaders();var
_;for(_ in kc)if(!(typeof kc[_]=="function"||typeof kc[_]=="object")){db.setRequestHeader(_.toString(),kc[_]);c.ev(5,"Setting HTTP Request Header, "+_+" ==> "+kc[_]+"'");}var
U=Mb!=null&&Mb instanceof jsx3.xml.Document&&!Mb.hasError()?Mb.serialize("1.0"):null;db.send(U,this.getTimeout());return true;}}};g.setRequestHeader=function(m,b){var
Kc=this.getHeaders();Kc[m]=b;};g.getHeaders=function(){if(this.jsxheaders==null){this.jsxheaders={};var
uc=this.getOperationNode().selectNodes("headers/record");for(var
vb=uc.iterator();vb.hasNext();){var
Ub=vb.next();this.jsxheaders[Ub.getAttribute("name")+""]=Ub.getAttribute("value")+"";}}return this.jsxheaders;};g.setTimeouts=function(r,m,h,p){c.ev(4,"Invalid method. setTimeouts() no longer valid. Use setTimeout() instead.");return this;};g.onTimeout=function(){this.publish({subject:"onTimeout"});};g.setTimeout=function(f,k,q){this.getRequest().subscribe("timeout",this,"onTimeout");this.subscribe("onTimeout",k,q);this.jsxtimeout=f;return this;};g.getTimeout=function(){return this.jsxtimeout;};g.resetRules=function(){var
mb=this.getRulesXML().selectNodes("//record[@jsxskip]");for(var
bb=mb.iterator();bb.hasNext();)bb.next().removeAttribute("jsxskip");return this;};g._resetNamespaceRegistry=function(){this.nshash={};this.nsinc=0;};c.ev=function(d,l){if(c.ST==null)if(jsx3.util.Logger){c.ST=jsx3.util.Logger.getLogger(c.jsxclass.getName());if(c.ST==null)return;}else return;c.ST.log(d,l);};g._reset=function(){this.resetRules();this._setValid(true);this._resetNamespaceRegistry();};g.getServiceMessage=function(l,s){var
Z,Y;this._reset();var
Ec=this.getOperationNode();c.ev(5,"Creating the request message for the operation, '"+this.getOperationName()+"', using the rules file located at, '"+this.getRulesURL()+"'");if(!s){Z=this._getOutboundStubDocument();s=this.getOutboundStubURL();}if(s||Z instanceof jsx3.xml.Document){var
R=this.getServer();if(!(Z instanceof jsx3.xml.Document)){s=R.resolveURI(s);Z=this.getServer().getCache().getOrOpenDocument(s,s);}if(!Z.hasError()){var
_=this.getOutboundStubPath();var
P=_.split("/");var
jc={};for(var
Yb=0;Yb<P.length;Yb++)if(P[Yb].search(/^([^:]*)(:)/)>-1)jc[RegExp.$1]=1;Z=Z.cloneDocument();Z.setSelectionLanguage("XPath");Y=Z.selectSingleNode(_,Z.getDeclaredNamespaces(jc));if(!Y){c.ev(2,"The stub path (typically the path to the SOAP Envelope Body) does not return a valid node ("+_+").");return;}}else{c.ev(2,"The outbound stub URL does not reference a valid document.  Please make sure that the URL is correct ("+s+") and that it returns a valid document:\n\t"+Z.getError());return;}}var
eb=Ec.selectSingleNode("record[@type='"+(l==null?"I":l.substring(0,1).toUpperCase())+"']");var
Kc=eb.selectNodes("record");var
mb;for(var
Yb=Kc.iterator();Yb.hasNext();)mb=this.doAddAndRecurse(Z,Y,Yb.next(),l,true);return Z?Z:mb;};g.registerNamespace=function(k,i,j){var
ob="";var
pc="";if(k!=""&&this.nshash[k]!=null){pc=k;ob=this.nshash[k];}else if(k!=""){this.nsinc++;this.nshash[k]="jsx"+this.nsinc;pc=k;ob="jsx"+this.nsinc;if(j!=true){var
Xb=i.getRootNode();Xb.setAttribute("xmlns:"+ob,pc);}}return {prefix:ob,uri:pc};};g.doAddAndRecurse=function(_jsxq,_jsxg,f,k,h){if(f.getAttribute("jsxskip"))return;var
Fb=false;var
Rb=this;var
Jc=function(j){j.setAttribute("jsxskip","1");};var
gc=function(j){j.removeAttribute("jsxskip");};var
mc=function(q){q.getParent().removeChild(q);};var
lc=function(a){Rb.setNodeValue(W,a);};var
wc=function(q){return Rb.getNamedNodeChild(q,f);};var
ec=function(a){Rb.getNamedRuleChild(a,f).setAttribute("jsxskip","1");};var
x=function(d){Rb.getNamedRuleChild(d,f).setAttribute("jsxskip","1");};var
Wb=function(j){Rb.getNamedRuleChild(j,f).removeAttribute("jsxskip");};var
cc=function(l){Rb.CDFCONTEXT.context=Rb.CDFCONTEXT.context.selectSingleNode(l);};var
Xb=function(i){Rb.CDFCONTEXT.records=Rb.CDFCONTEXT.context.selectNodes(i);};var
v=f.getAttribute("tns");var
z=v?this.registerNamespace(v,_jsxq,h):{prefix:"",uri:""};var
db=f.getAttribute("jsxtext");if(f.getAttribute("type")=="A"){var
ob=true;var
W=_jsxq.createNode(2,z.prefix+(z.prefix!=""?":":"")+db,z.uri);_jsxg.setAttributeNode(W);}else if(f.getAttribute("type")=="D"){var
ob=false;var
W=_jsxq.createNode(4);_jsxg.appendChild(W);}else{var
ob=false;if(_jsxq){var
W=_jsxq.createNode(1,z.prefix+(z.prefix!=""?":":"")+db,z.uri);_jsxg.appendChild(W);}else{_jsxq=new
jsx3.xml.Document();var
W=_jsxq.createDocumentElement(z.prefix+(z.prefix!=""?":":"")+f.getAttribute("jsxtext"),z.uri);}var
D=f.selectSingleNode("ancestor-or-self::record[(@type='I' or @type='O') and @soapuse='encoded' and @soapencstyle='"+c.ns["SOAP-ENC"]+"']");if(D!=null&&D!=""){var
jc;if((jc=f.getAttribute("datatype"))!=null&&jc!=""){var
Db=f.getAttribute("simple");if(Db!=null&&Db!=""){if(jc.indexOf(":")>0)jc=jc.replace(/[^:]*[:]?/,"");jc="xsd:"+jc;}else{if(jc.indexOf(":")>0)jc=jc.replace(/[^:]*[:]?/,"");v=f.getAttribute("ttns");z=this.registerNamespace(v,_jsxq,h);jc=z.prefix==""?jc:z.prefix+":"+jc;}var
yb=_jsxq.createNode(2,"xsi:type","http://www.w3.org/2001/XMLSchema-instance");yb.setValue(jc);W.setAttributeNode(yb);}}}this.publish({subject:"onProcessRule",rule:f,action:"Create Node",description:"<"+W.getNodeName()+">",level:6});var
qc=f.selectNodes("mappings/record");var
U=false;var
vb;for(var
tb=qc.iterator();tb.hasNext();){var
cb=this.CDFCONTEXT?this.CDFCONTEXT.context:null;var
_=this.CDFCONTEXT?this.CDFCONTEXT.records:null;var
u=this.CDFCONTEXT&&this.CDFCONTEXT.parentContext?this.CDFCONTEXT.parentcontext:null;var
Ic=tb.next();var
ub=Ic.getAttribute("name");var
jb=Ic.getAttribute("value");var
C=this.getNamespace();if(C==null||jsx3.util.strTrim(C)=="")C=null;if(ub=="DOM"){var
Ec=jsx3.GO(jb,C);if(Ec!=null){this.publish({subject:"onProcessRule",rule:f,action:"Map to DOM",description:'jsx3.GO("'+jb+'"'+(C?',"'+C+'"':"")+").getValue();",level:6});this.doMapAndUpdate(W,Ec,"OUTBOUND",f);}else c.ev(2,"Could not map the JSX object named, '"+jb+"', because it is null.");}else if(ub=="NODE"||ub=="CACHE"){var
Mb=jb.split("::");var
t=Mb[0];var
hc=this.getServer();if(hc!=null){var
pb=hc.getCache().getDocument(t);}else var
pb=jsx3.CACHE.getDocument(t);if(pb!=null){var
N=pb.selectSingleNode(Mb[1]);if(N!=null){this.publish({subject:"onProcessRule",rule:f,action:"Map to Cache Node",description:(C?'jsx3.getApp("'+C+'")':"jsx3.CACHE")+'.getDocument("'+Mb[0]+'").selectSingleNode("'+Mb[1]+'").getValue();',level:6});this.updateNode(W,N,"OUTBOUND");}else c.ev(2,"The map has a rule that references an invalid path to a node in the XML cache document, "+Mb[0]+": "+Mb[1]+".");}else c.ev(2,"The map has a rule that references an invalid XML document in the cache: "+Mb[0]+".");}else if(ub=="CDF Document"){this.publish({subject:"onProcessRule",rule:f,action:"Map to CDF Document",description:(C?'jsx3.getApp("'+C+'")':"jsx3.CACHE")+'.getDocument("'+jb+'");',level:6});this.getCDFDocument(jb,"OUTBOUND",C);}else if(ub=="CDF Record"){var
fb;if(fb=this.CDFCONTEXT.records.next()){this.publish({subject:"onProcessRule",rule:f,action:"Map to CDF Record",description:'this.CDFCONTEXT.records.next().selectNodes("record");',level:6});var
K=fb;var
dc=fb.selectNodes("record");this.CDFCONTEXT=new
c.CdfContext(K,this.CDFCONTEXT,dc);vb=true;U=true;}else{mc(W);vb=false;}}else if(ub=="CDF Attribute"){var
H=this.CDFCONTEXT.context.getAttribute(jb);if(H){this.publish({subject:"onProcessRule",rule:f,action:"Map to CDF Attribute",description:'this.CDFCONTEXT.context.getAttribute("'+jb+'");',level:6});lc(H);}}else if(ub=="Script"){this.publish({subject:"onProcessRule",rule:f,action:"Map to Script",description:"this.eval("+jb+");",level:6});var
xc={MESSAGENODE:W,my:Rb,OBJECTNAME:jb,OBJECTTYPE:ub,CDFCONTEXTPARENT:u,CDFCONTEXT:cb,CDFRECORDS:_,setCDFRecords:Xb,setCDFContext:cc,enableNamedRule:Wb,disableNamedRule:x,enableReferencedRule:Jc,disableReferencedRule:gc,skipNamedRule:ec,getNamedChild:wc,setValue:lc,removeChild:mc};var
ac=this.eval(jb,xc);}}if(W.getValue()==""&&k!=null&&f.selectSingleNode("record")==null){var
J=f.getAttribute("datatype");if(J!=null&&J!=""){var
B=c.simpletypes[J.substring(J.indexOf(":")+1)];var
M=B!=null?typeof B=="function"?B():B:"???";W.setValue(M);}}else if(W.getValue()==""&&f.selectSingleNode("record")==null&&f.getAttribute("type")!="A"&&!h&&f.selectSingleNode("restrictions/record[@name='nillable' and @value='true']")==null){mc(W);Fb=true;}if(Fb!=true)this.validate(W,f);if(vb==null){var
Pb=(Pb=f.getAttribute("repeat"))!=null?Pb:false;vb=this.eval(Pb);}if(!Fb&&f.getAttribute("groupref")!="1"&&f.getParent().getAttribute("groupref")=="1"){var
Nc=false;var
Fc=W.getParent();var
Gb=f.getParent();while(Gb.getAttribute("groupref")=="1"){Gb=Gb.getParent();var
F=Fc;Fc=Fc.getParent();}Fc.insertBefore(W,F);}else if(f.getAttribute("groupref")=="1"){var
Nc=true;}else var
Nc=false;var
rc=f.selectNodes("record");for(var
tb=rc.iterator();tb.hasNext();)this.doAddAndRecurse(_jsxq,W,tb.next(),k,null);if(U)this.CDFCONTEXT=this.CDFCONTEXT.parentcontext;var
v=f.getAttribute("soaparray");if(v!=null&&v!=""){z=this.registerNamespace(v,_jsxq,h);W.setValue(z.prefix+":"+f.getAttribute("soaparraytype"));}if(f.getAttribute("datatype")=="Array"&&f.getAttribute("ttns")=="http://schemas.xmlsoap.org/soap/encoding/"){var
Cc=W.getAttributes();for(var
tb=Cc.iterator();tb.hasNext();){var
kb=tb.next();if(kb.getBaseName()=="arrayType"){var
Dc=f.selectSingleNode("record[@jsxtext='arrayType']/@ttns").getValue();var
Gc=this.nshash[Dc];var
A=Gc+":"+f.selectSingleNode("record[@jsxtext='arrayType']/@datatype").getValue()+"["+W.selectNodes("./*").size()+"]";kb.setValue(A);}}}if(vb&&!Nc){this.doAddAndRecurse(_jsxq,_jsxg,f,k,null);}else if(Nc)W.getParent().removeChild(W);return _jsxq;};g.findNameByValue=function(i,o){for(var C in i)if(i[C]==o)return C.toString();};g.validate=function(m,o){var
S=o.selectNodes("restrictions/record[@name!='minoccur' and @name!='maxoccur']");if(S.size()>0){var
pb=m.getValue()+"";if(o.selectSingleNode("restrictions/record[@name='enumeration' and @value='"+pb+"']")!=null)return true;for(var
Wb=S.iterator();Wb.hasNext();){var
kb=Wb.next();var
ob=kb.getAttribute("name");var
jb=kb.getAttribute("value");if(ob=="enumeration"){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="maxExclusive"&&!(pb<jb)){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="maxInclusive"&&!(pb<=jb)){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="minInclusive"&&!(pb>=jb)){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="minExclusive"&&!(pb>jb)){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="length"&&pb.length!=Number(jb)){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="maxLength"&&pb.length>Number(jb)){this.invalidate(m,o,pb,ob,jb);return false;}else if(ob=="pattern"){var
ec=new
RegExp(jb);if(pb.search(ec)!=0){this.invalidate(m,o,pb,ob,jb);return false;}}}}return true;};g.invalidate=function(q,k,h,l,a){this._setValid(false);this.publish({subject:"onInvalid",rule:k,message:q,type:l,value:a});this.publish({subject:"onProcessRule",rule:k,action:"Invalidate",description:h+" != "+l+":"+a,level:3});};g.updateNode=function(k,m,e){if(e=="INBOUND"){var
J=k;var
X=m;}else{var
J=m;var
X=k;}var
t=this.getNodeValue(J);this.setNodeValue(X,t);};g.setNodeValue=function(r,i){r.setValue(i+"");};g.getNodeValue=function(f){return f.getValue();};g.doMapAndUpdate=function(r,e,l,q){if(e.isInstanceOf("jsx3.gui.Form")){if(e.isInstanceOf("jsx3.gui.RadioButton")){if(l=="INBOUND"){e.setGroupValue(this.getNodeValue(r));}else{var
P=e.getGroupValue();this.setNodeValue(r,P==null?"":P);}}else if(e.isInstanceOf("jsx3.gui.CheckBox")){if(l=="INBOUND"){var
pb=this.getNodeValue(r);e.setChecked(this.eval(pb)?1:0);}else this.setNodeValue(r,e.getChecked()?"true":"false");}else if(l=="INBOUND"){e.setValue(this.getNodeValue(r));}else if(l=="OUTBOUND")this.setNodeValue(r,e.getValue()+"");}else if(e.isInstanceOf("jsx3.gui.Block"))if(l=="INBOUND"){e.setText(this.getNodeValue(r),true);}else this.setNodeValue(r,e.getText());};g.doReadAndRecurse=function(p,k){var
Jb=this;var
Ac=function(o){return Jb.getNamedNodeChild(o,p);};this.publish({subject:"onProcessRule",rule:k,action:"Locate Node",description:"<"+p.getNodeName()+">",level:6});var
Gc=k.selectNodes("mappings/record");var
Kb=true;var
wc=false;for(var
M=Gc.iterator();M.hasNext();){var
jc=this.CDFCONTEXT?this.CDFCONTEXT.context:null;var
B=M.next();var
zb=B.getAttribute("name");var
J=B.getAttribute("value");var
Zb=this.getNamespace();if(zb=="DOM"){var
Db=jsx3.GO(J,Zb);if(Db!=null){this.publish({subject:"onProcessRule",rule:k,action:"Map to DOM",description:'jsx3.GO("'+J+'"'+(Zb?',"'+Zb+'"':"")+').setValue("'+p.getValue()+'");',level:6});this.doMapAndUpdate(p,Db,"INBOUND",k);}else c.ev(2,"Could not map the JSX object named, '"+J+"', because it is null.");}else if(zb=="NODE"||zb=="CACHE"){var
Gb=J.split("::");var
t=Gb[0];var
nc=this.getServer();if(nc!=null){var
Fc=nc.getCache().getDocument(t);}else var
Fc=jsx3.CACHE.getDocument(t);if(Fc!=null){var
V=Fc.selectSingleNode(Gb[1]);if(V!=null){this.publish({subject:"onProcessRule",rule:k,action:"Map to Cache Node",level:6,description:(Zb?'jsx3.getApp("'+Zb+'")':"jsx3.CACHE")+'.getDocument("'+Gb[0]+'").selectSingleNode("'+Gb[1]+'").setValue("'+jsx3.util.strTruncate(p.getValue(),30,null,0.6666666666666666)+'");'});this.updateNode(p,V,"INBOUND");}else c.ev(2,"The map has a rule that references an invalid path to a node in the XML cache document, "+Gb[0]+": "+Gb[1]+".");}else c.ev(2,"The map has a rule that references an invalid XML document in the cache: "+Gb[0]+".");}else if(zb=="CDF Document"){this.publish({subject:"onProcessRule",rule:k,action:"Map to CDF Document",description:(Zb?'jsx3.getApp("'+Zb+'")':"jsx3.CACHE")+'.setDocument("'+J+'",jsx3.xml.CDF.Document.newDocument());',level:6});this.getCDFDocument(J,"INBOUND",Zb);}else if(zb=="CDF Record"){this.publish({subject:"onProcessRule",rule:k,action:"Map to CDF Record",description:'this.CDFCONTEXT.context.createNode(jsx3.xml.Entity.TYPEELEMENT,"record");',level:6});var
sb=this.CDFCONTEXT.context.createNode(1,"record");sb.setAttribute("jsxid",this.getUniqueId());this.CDFCONTEXT.context.appendChild(sb);this.CDFCONTEXT=new
c.CdfContext(sb,this.CDFCONTEXT);wc=true;}else if(zb=="CDF Attribute"){this.publish({subject:"onProcessRule",rule:k,action:"Map to CDF Attribute",description:'this.CDFCONTEXT.context.setAttribute("'+J+'","'+jsx3.util.strTruncate(p.getValue(),30,null,0.6666666666666666)+'");',level:6});this.CDFCONTEXT.context.setAttribute(J,p.getValue());Kb=false;}else if(zb=="Script"){this.publish({subject:"onProcessRule",rule:k,action:"Map to Script",description:"this.eval("+J+");",level:6});var
z={my:Jb,OBJECTNAME:J,OBJECTTYPE:zb,CDFCONTEXT:jc,MESSAGENODE:p,RULENODE:k,RECURSE:Kb,getNamedChild:Ac};this.eval(J,z);}}if(Kb){var
Mc=k.selectNodes("*[name()='record' and (record or mappings)]");for(var
M=Mc.iterator();M.hasNext();){var
N=M.next();var
Ec=N.getAttribute("jsxtext");if(N.getAttribute("type")=="A"){var
X=p.getAttributes();L2:for(var
Pb=X.iterator();Pb.hasNext();){var
Ib=Pb.next();if(Ib.getBaseName()==Ec){this.doReadAndRecurse(Ib,N);break L2;}}}else{var
X=p.selectNodes("*[local-name()='"+Ec+"']");for(var
Pb=X.iterator();Pb.hasNext();)this.doReadAndRecurse(Pb.next(),N);}}}if(wc)this.CDFCONTEXT=this.CDFCONTEXT.parentcontext;};c.CdfContext=function(n,k,l){this.context=n;this.parentcontext=k;this.records=l;};g.getNamedNodeChild=function(r,m){var
Hb=m.getChildNodes();for(var
A=Hb.iterator();A.hasNext();){var
Jb=A.next();var
wc=Jb.getBaseName();if(wc==r)return Jb;}};g.doval=function(b){this.eval(b);};g.getNamedRuleChild=function(j,d){return d.selectSingleNode("record[@jsxtext='"+j+"']");};g.getUniqueId=function(){return jsx3.xml.CDF.getKey();};g.onResponse=function(s){var
Jc=s.target;if(Jc instanceof jsx3.net.Request){this.responseheaders=Jc.getAllResponseHeaders();this.status=Jc.getStatus();this.statusText=Jc.getStatusText();c.ev(5,"The call to the operation, '"+this.getOperationName()+"', hosted at '"+this.getEndpointURL()+"' just returned with the HTTP Status code, "+this.status);if(this.status!=200&&this.status!=202){var
vc=true;c.ev(2,"The call to the operation, '"+this.getOperationName()+"', hosted at '"+Jc.getURL()+"' has returned an error (HTTP Status Code: '"+this.status+"').\nDescription: "+this.statusText);}else var
vc=false;var
fc=Jc.getResponseXML();if(fc&&!fc.hasError()){this.setInboundDocument(fc);}else{c.ev(2,"The call to the operation, '"+this.getOperationName()+"', hosted at '"+this.getEndpointURL()+"' did not return a valid response document. The inbound filter (e.g., doInboundFilter()) as well as the inbound mappings (e.g., doInboundMap()) will not be executed.\nDescription: "+this.statusText);this.onError();return;}}else{this.setInboundDocument(Jc.getResponseXML());this.status=200;this.statusText="Executing in Static mode, using service message proxy, '"+this.getInboundURL()+"'.";}var
x=this.getMEPNode("O");if(x){this.doInboundFilter();this.doInboundMap();}else c.ev(5,"An alternate message exchange pattern was encountered for the mapping rule: one-way. The inbound filter and inbound mappings will NOT be run.");if(vc){this.onError();}else this.onSuccess();};g.getCDFDocument=function(d,i,s){var
t=this.getServer();var
zb=t!=null?t.getCache():jsx3.CACHE;if(i=="OUTBOUND"){var
Nc=zb.getDocument(d);if(Nc){this.CDFCONTEXT=new
c.CdfContext(Nc.getRootNode(),null,Nc.getRootNode().selectNodes("record"));}else c.ev(2,"The Cache document, '"+d+"', is being referenced as a bound CDF document for the operation, '"+this.getOperationName()+"'. However, this document cannot be located.");}else{var
Nc=jsx3.xml.CDF.Document.newDocument();zb.setDocument(d,Nc);this.CDFCONTEXT=new
c.CdfContext(Nc.getRootNode(),null);}};g.getStatus=function(){var
jc=this._status||this.status;return !jc?200:jc;};g.setStatus=function(k){this._status=k;};g.getMode=function(){return this._jsxmode!=null?this._jsxmode:this.getServer().getEnv("mode");};g.setMode=function(s){this._jsxmode=s;};g.doInboundMap=function(){c.ev(5,"Executing the Inbound Mappings.");var
R=this.getOperationNode();if(R){var
Wb=this.getInboundDocument();var
pb=this.getStatus();var
u=pb!=200&&pb!=202&&pb!=0?"F":"O";if(u=="O"&&this.di instanceof jsx3.xml.Document){c.ev(5,"This operation uses a compiled XSLT document to transform the server results to CDF.");jsx3.require("jsx3.xml.Template");var
hc=new
jsx3.xml.Template(this.di);var
Nb=jsx3.xml.CDF.Document.wrap(hc.transformToObject(Wb));if(!Nb.hasError()){c.ev(5,"The compiled transformation was successful. Adding the CDF to the server's cache.");var
Z=this.getMEPNode("O");var
y=Z.selectSingleNode(".//record/mappings/record[@name='CDF Document']");if(y){var
N=y.getAttribute("value");if(N&&(N=jsx3.util.strTrim(String(N)))!=""){var
jb=this.getServer();var
yb=jb!=null?jb.getCache():jsx3.CACHE;yb.setDocument(N,Nb);}else c.ev(2,"The CDF document that was just created could not be cached, because it has no name. Update the Rules document to use a name for the CDF document being created.");}else c.ev(2,"CDF Mappings require that the first mapping be of type 'CDF Document' and that this mapping type exist only once for an output. Update the Rules document to use a a CDF Document mapping.");}else c.ev(2,"The merge failed and a CDF Document could not be created, using the compiled CXF. Run this operation in an uncompiled state to better discern the cause of this error:\n\t"+Nb.getError());}else{var
tc=this.getMEPNode(u);if(tc==null&&u=="F")tc=this.getMEPNode("O");if(tc){var
cc=tc.selectNodes("record");Wb.setSelectionLanguage("XPath");this.getRulesXML().setSelectionLanguage("XPath");for(var
bb=cc.iterator();bb.hasNext();){var
uc=bb.next();var
qc=uc.getAttribute("jsxtext");var
qb=uc.getAttribute("tns");var
U="";if(qb!=null&&jsx3.util.strTrim(qb)!=""){U="jsx:";Wb.setSelectionNamespaces("xmlns:jsx='"+qb+"'");}var
P="//"+U+qc;var
Tb=Wb.selectSingleNode(P);if(Tb!=null)if(!Tb.equals(Wb.getRootNode())){var
v=Tb.getParent();var
kb=v.selectNodes(U+qc);for(var
Sb=kb.iterator();Sb.hasNext();)this.doReadAndRecurse(Sb.next(),uc);}else this.doReadAndRecurse(Tb,uc);}}else c.ev(5,"An alternate message exchange pattern was encountered for the mapping rule: one-way. The inbound mappings will not be run.");}}};c.getNSForURL=function(a,s){var
nc=a.getRootNode().getAttributes();for(var
B=nc.size()-1;B>=0;B--)if(nc.get(B).getValue()==s)return nc.get(B).getBaseName();};c.getURLForNS=function(p,i){if(jsx3.util.strEmpty(i))return null;try{var
Kc=p.selectSingleNode("//*[@xmlns:"+i+"]/@xmlns:"+i);}catch(Nc){var
rb={};rb.FUNCTION="jsx3.net.Service.getURLForNS";rb.PREFIX=i+"";rb.DESCRIPTION="Could not finde the URI for the given namespace prefix.";jsx3.util.Logger.logError(rb);return null;}return Kc?Kc.getValue():null;};c.getVersion=function(){return "3.0.00";};g.compile=function(){this._resetCompiler();var
dc=this.getMEPNode("O");var
rc=[];rc.push('<?xml version="1.0" ?>');rc.push('<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" ');rc.push('<xsl:output method="xml" omit-xml-declaration="no"/>');this._compile(dc,rc,true);rc.push("</xsl:stylesheet>");var
Ec=[],Bb=[];for(var ob in this.Xn){Ec.push(this.Xn[ob]);Bb.push("xmlns:"+this.Xn[ob]+'="'+ob+'"');}rc[1]+=(Bb.join(" ")+' exclude-result-prefixes="'+Ec.join(" ")+'" >');var
Nc=rc.join("\n");var
fc=new
jsx3.xml.Document();fc.loadXML(Nc);if(fc.hasError()){c.ev(2,"The XSLT could not be compiled from the CXF source document:\n\t"+fc.getError());}else{this.di=fc;return fc;}};g._compile=function(q,s,h){var
C=this.MP(q);if(h){s.push('<xsl:template match="/">');}else{var
G=C?C.prefix+":":"";var
ac=q.getAttribute("jsxtext");if(q.getAttribute("type")=="A")ac="@"+ac;var
_b=q.getAttribute("jsxid");s.push('<xsl:template match="'+G+ac+'" mode="x'+_b+'">');}var
eb=q.selectNodes("mappings/record[@name='CDF Document' or @name='CDF Record' or @name='CDF Attribute']");var
Nc=[];for(var
Ac=eb.iterator();Ac.hasNext();){var
jb=Ac.next();var
B=jb.getAttribute("name");var
A=jb.getAttribute("value");if(B=="CDF Document"){s.push('<data jsxid="jsxroot">');Nc.push("</data>");}else if(B=="CDF Record"){s.push('<record jsxid="{generate-id()}">');Nc.push("</record>");}else s.push('<xsl:attribute name="'+A+'"><xsl:value-of select="."/></xsl:attribute>');}var
Dc=q.selectNodes("record");for(var
Ac=Dc.iterator();Ac.hasNext();){var
Fb=Ac.next();var
Xb=this.MP(Fb);var
G=Xb?Xb.prefix+":":"";if(h)G="//"+G;var
ac=Fb.getAttribute("jsxtext");if(Fb.getAttribute("type")=="A")ac="@"+ac;var
_b=Fb.getAttribute("jsxid");s.push('<xsl:apply-templates select="'+G+ac+'" mode="x'+_b+'"/>');}for(var
Ac=Nc.length-1;Ac>=0;Ac--)s.push(Nc[Ac]);s.push("</xsl:template>");for(var
Ac=Dc.iterator();Ac.hasNext();){var
Fb=Ac.next();this._compile(Fb,s);}};g._resetCompiler=function(){this.di=null;this.Xn={};this.ik=0;};g.MP=function(r){var
hb=r.getAttribute("tns");if(hb&&(hb=jsx3.util.strTrim(String(hb)))!=""){if(!this.Xn[hb]){this.ik+=1;this.Xn[hb]="jsx"+this.ik;}return {prefix:"jsx"+this.ik,namespace:hb};}};});jsx3.net.Service.prototype.getOperation=jsx3.net.Service.prototype.getOperationName;jsx3.net.Service.prototype.setOperation=jsx3.net.Service.prototype.setOperationName;jsx3.net.Service.prototype.getStubURL=jsx3.net.Service.prototype.getOutboundStubURL;jsx3.net.Service.prototype.setStubURL=jsx3.net.Service.prototype.setOutboundStubURL;jsx3.net.Service.prototype.addHeader=jsx3.net.Service.prototype.setRequestHeader;jsx3.net.Service.prototype.setServiceURL=jsx3.net.Service.prototype.setEndpointURL;jsx3.Service=jsx3.net.Service;
