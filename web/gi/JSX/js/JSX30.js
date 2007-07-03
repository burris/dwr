/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
if(window["jsx_main"]==null)window["jsx_main"]=function(){var
ic=function(){var
kb=this.agt=navigator.userAgent.toLowerCase();var
J=parseInt(navigator.appVersion);var
qb=parseFloat(navigator.appVersion);this.nav=kb.indexOf("mozilla")!=-1&&kb.indexOf("spoofer")<0&&kb.indexOf("compatible")==-1&&kb.indexOf("opera")<0&&kb.indexOf("webtv")<0&&kb.indexOf("hotjava")<0;this.nav6=this.nav&&J==5;this.nav6up=this.nav&&J>=5;this.gecko=this.nav6up&&kb.indexOf("gecko")>=0;this.geckook=this.gecko&&this.a6("gecko/")>=20050915;this.ffox=this.nav6up&&kb.indexOf("firefox")>=0;this.ffox15=this.ffox&&this.a6("firefox/")>=1.5;this.ffox2=this.ffox15&&this.a6("firefox/")>=2;this.ffox3=this.ffox2&&this.a6("firefox/")>=3;this.safari=kb.indexOf("applewebkit")>=0;this.safari2=this.safari&&this.a6("applewebkit/")>=420;this.opera=kb.indexOf("opera")>=0;if(this.opera){var
A=this.a6("opera ");this.opera85=A>=8.5&&A<9;this.opera9=A>=9;}this.ie=kb.indexOf("msie")>=0&&!this.opera;if(this.ie){var
vb=this.a6("msie ");this.ie6=J==4&&Math.floor(vb)==6;this.ie6up=vb>=6;this.ie7=Math.floor(vb)==7;this.ie7up=vb>=7;this.ie8=Math.floor(vb)==8;this.ie8up=vb>=8;}};ic.prototype.a6=function(q){var
kc=this.agt.indexOf(q);return kc>=0?parseFloat(this.agt.substring(kc+q.length)):0;};if(window["jsx3"]==null){window.jsx3={};jsx3.lang={};jsx3.util={};jsx3.SYSTEM_ROOT="JSX";jsx3.SYSTEM_SCRIPTS="JSX"+"/js";jsx3.MAIN_SCRIPT=jsx3.SYSTEM_SCRIPTS+"/JSX30.js";jsx3.APP_DIR_NAME="JSXAPPS";jsx3.ABSOLUTEPATH="";jsx3.APPPATH="";jsx3.STARTUP_EVENT=null;jsx3.rR={};jsx3.getEnv=function(n){return jsx3.rR[n];};jsx3.setEnv=function(e,m){if(jsx3.rR[e]!=null&&jsx3.rR[e]!=m)window.alert(jsx3._msg("boot.env_reset",e,jsx3.rR[e],m));jsx3.rR[e]=m;};jsx3._msg=function(m,d){if(jsx3.System&&jsx3.System.getMessage)return jsx3.System.getMessage.apply(null,arguments);var
qb=new
Array(arguments.length);for(var
Mb=0;Mb<qb.length;Mb++)qb[Mb]=arguments[Mb];return qb.join(" ");};var
mc={};mc.A8=function(g,a,l){if(this.j3==null)this.j3={};var
tc=this.j3[g];if(tc==null)tc=this.j3[g]=[];tc[tc.length]=[a,l];};mc.Ay=function(j,d){if(this.j3!=null)for(var F in this.j3){var
Hb=this.j3[j];for(var
Wb=0;Wb<Hb.length;Wb++)if(Hb[Wb][0]==d)Hb.splice(Wb--
,1);}};mc.T3=function(f){if(this.j3!=null){var
xb=this.j3[f.subject];if(xb){if(f.wK==null)f.wK=this;xb=xb.concat();for(var
Bb=0;Bb<xb.length;Bb++)if(typeof xb[Bb][0]=="function")xb[Bb][0](f);else if(typeof xb[Bb][1]=="string")xb[Bb][0][xb[Bb][1]](f);else xb[Bb][1].apply(xb[Bb][0],[f]);}}};mc.OW=function(b){b.A8=this.A8;b.Ay=this.Ay;b.T3=this.T3;};jsx3.util.JobManager=function(){this.init.apply(this,arguments);};var
zc=function(m,b){b.init=function(){this.reset();var
Vb=this;this.mU=function(){this.constructor.prototype.finish.apply(this);Vb.KD(this);};};b.addJob=function(h,c){var
J=h.getId();if(this.cq[J])throw new
Error(jsx3._msg("job.dup",J));h.dU=this;this.cq[J]=h;this.lB[J]=[];this.lR++;for(var
hc=1;hc<arguments.length;hc++){c=arguments[hc];if(c instanceof Array)for(var
Ob=0;Ob<c.length;Ob++)this.addPrereq(J,c[Ob]);else if(c!=null)this.addPrereq(J,c);}this.m5(J);return h;};b.addPrereq=function(q,n){if(!this.cq[n])return;if(!this.cq[q])throw new
Error(jsx3._msg("job.pre_bad",q,n));this.lB[q].push(n);if(!this.IX[n])this.IX[n]=[q];else this.IX[n].push(q);};b.getJob=function(p){return this.cq[p];};b.start=function(){if(!this.TN){this.TN=true;this.m5();}};b.pause=function(){this.TN=false;};b.reset=function(){if(this.cq!=null)for(var oc in this.cq)this.cq[oc].finish=jsx3.util.Job.prototype.finish;this.cq={};this.lB={};this.IX={};this.DQ={};this.TN=false;this.lR=0;this.qw=0;this.V0=[];this.QK=false;};b.getWaitCt=function(){return this.lR;};b.getDoneCt=function(){return this.qw;};b.m5=function(l){if(this.TN)if(l){if(this.lB[l].length==0&&!this.DQ[l])this.U2(l);}else for(l in this.cq)if(this.lB[l].length==0&&!this.DQ[l])this.U2(l);};b.U2=function(n){var
lc=this.cq[n];this.DQ[n]=true;var
ub=lc.run();if(typeof ub=="undefined"||ub==1||ub==0&&lc.getState()==1){this.KD(lc);}else if(ub==2){var
v=this;window.setTimeout(function(){v.KD(lc);},0);}else if(ub==3){this.DQ[n]=false;return;}else lc.finish=this.mU;delete lc.run;};b.KD=function(r){var
ec=r.getId();delete this.DQ[ec];delete this.cq[ec];delete this.lB[ec];this.V0[this.V0.length]=ec;if(!this.QK)this.Y4();};b.Y4=function(){this.QK=true;while(this.V0.length>0){var
X=this.V0.shift();this.qw++;this.lR--;var
oc=this.IX[X];if(oc){delete this.IX[X];for(var
db=0;db<oc.length;db++){var
Ab=oc[db];var
Hb=this.lB[Ab];for(var
x=0;x<Hb.length;x++)if(Hb[x]==X){Hb.splice(x,1);break;}this.m5(Ab);}}}this.QK=false;if(this.lR==0){if(this.publish)this.publish({subject:"done"});}else{}};};zc(jsx3.util.JobManager,jsx3.util.JobManager.prototype);jsx3.util.Job=function(){this.init.apply(this,arguments);};var
Gb=function(h,d){h.WAIT=0;h.DONE=1;h.SLEEP=2;h.PUSH=3;h.LI=0;h.FINISHED=1;h.Y9=0;d.init=function(k,l){this.SU=k!=null?k:h.Y9++;this.RD=0;if(l)this.run=l;};d.getId=function(){return this.SU;};d.getManager=function(){return this.dU;};d.run=function(){return 1;};d.finish=function(){this.RD=1;if(this.T3)this.T3({subject:"finish"});if(jsx3.lang.ClassLoader.ez[this.ei]==this)jsx3.lang.ClassLoader.ez[this.ei]=1;};d.getState=function(){return this.RD;};d.toString=function(){return this.SU;};d._checkAlreadyRequested=function(){var
t=jsx3.lang.ClassLoader.ez;if(t[this.ei] instanceof h){this.dU.addPrereq(this.getId(),t[this.ei].getId());return 3;}else if(t[this.ei])return 1;t[this.ei]=this;};};Gb(jsx3.util.Job,jsx3.util.Job.prototype);jsx3.lang.ClassLoader=function(j){this.init(j);};var
Jc=function(j,e){j.ez={};var
Qb=jsx3.util.Job;var
gc=null;mc.OW(e);j.JsJob=function(h,a){this.SU=h||a;this.ei=a;};gc=j.JsJob.prototype=new
Qb();gc.run=function(){var
ec=this._checkAlreadyRequested();if(ec)return ec;var
jc=document.createElement("script");jc.src=this.ei;jc.type="text/javascript";jc.id=this.SU;var
rb=this;if(jsx3.CLASS_LOADER.IE){jc.onreadystatechange=function(){var
tb=this.readyState;if(tb=="loaded"||tb=="interactive"||tb=="complete"){jc.onreadystatechange=null;rb.finish();}};}else jc.onload=function(){jc.onload=null;rb.finish();};jsx3.CLASS_LOADER.FN("Loading: "+this.ei+" ...");document.getElementsByTagName("head")[0].appendChild(jc);return 0;};mc.OW(gc);j.CssJob=function(h,a){this.SU=h||a;this.ei=a;};gc=j.CssJob.prototype=new
Qb();gc.run=function(){var
Zb=this._checkAlreadyRequested();if(Zb)return Zb;var
x=document.createElement("link");x.id=this.SU;x.href=this.ei;x.rel="stylesheet";x.type="text/css";if(jsx3.CLASS_LOADER.IE){var
tc=this;x.onload=function(){x.onload=null;tc.finish();};}jsx3.CLASS_LOADER.FN("Loading: "+this.ei+" ...");document.getElementsByTagName("head")[0].appendChild(x);return 1;};gc.toString=function(){return this.SU+" "+this.ei;};j.XmlJob=function(h,a,l,n,g){this.SU=h||a;this.ei=a;this.k0=l;this.y5=n;this.vg=g;};gc=j.XmlJob.prototype=new
Qb();gc.run=function(){this.ut();return 0;};gc.getDocument=function(){return this._h;};gc.ut=function(){var
dc=this._h=(this.vg||jsx3.xml.Document.jsxclass).newInstance();dc.setAsync(true);dc.subscribe("*",this,"hF");jsx3.CLASS_LOADER.FN("Loading: "+this.ei+" ...");dc.load(this.ei);};gc.hF=function(){if(this.k0)this.k0.setDocument(this.y5,this._h);this.finish();};j.JssJob=function(q,k,s,g,p){this.SU=q||k;this.ei=k;this.Fq=s;this.k0=g;this.y5=p;};gc=j.JssJob.prototype=new
j.XmlJob();gc.run=function(){var
M=this.k0.getDocument(this.y5);if(M){this.Fq.loadXML(M,this.y5);return 1;}else{this.ut();return 0;}};gc.hF=function(a){var
Db=a.target;this.k0.setDocument(this.y5,Db);if(!Db.hasError()){this.Fq.loadXML(Db,this.y5);}else{}this.finish();};j.PropsBundleJob=function(k,s,q,o){this.SU=k;this.ei=k;this.Fq=s;this.k0=q;this.mz=o;};gc=j.PropsBundleJob.prototype=new
j.XmlJob();gc.run=function(){var
Ac=this.k0.getDocument(this.ei);if(Ac){this.Fq.addParent(jsx3.app.PropsBundle.getProps(this.ei,this.mz,this.k0));return 1;}else{this.ut();return 0;}};gc.hF=function(m){this.k0.setDocument(this.ei,m.target);this.Fq.addParent(jsx3.app.PropsBundle.getProps(this.ei,this.mz,this.k0));this.finish();};j.ClassJob=function(b){this.SU=b;};gc=j.ClassJob.prototype=new
Qb();gc.run=function(){if(jsx3.lang.Class&&jsx3.lang.Class.forName(this.SU))return 1;jsx3.CLASS_LOADER.A8("class",this,"TF");return 0;};gc.TF=function(d){if(d.name==this.SU){jsx3.CLASS_LOADER.Ay("class",this);this.finish();}};j.SYSTEM_SCRIPTS=["@path@/jsx.js"];j.INCLUDES=[{id:"jsx_css_ie",type:"css",browser:"IE_MQ",src:"css/ie/JSX.css"},{id:"jsx_css_ie_strict",type:"css",browser:"IE_MS",src:"css/ie/JSX.css"},{id:"jsx_css_mz",type:"css",browser:"MOZ,SAF",src:"css/@path@/JSX.css"},{id:"jsx_jss_css",type:"ljss",src:"jss/CSS.xml"},{id:"jsx_locale",type:"ljss",src:"locale/locale.xml"},{id:"jsx_messages",type:"ljss",src:"locale/messages.xml"}];j.Tv=11;j.Yp=12;j.MO=13;j.rM=21;j.AU=31;j.lP=32;j.S7=33;j.A5=35;j.yt=36;j.WW=41;j.H_=99;j.TH={11:"ie6",12:"ie7",13:"ie7",21:"fx",31:"fx",32:"fx",33:"fx",35:"fx",36:"fx",41:"saf"};j.or={11:["IE","IE6","VML"],12:["IE","IE7","VML"],21:["OPERA"],31:["FX","MOZ","SVG","GKO"],41:["SAF","SVG","KON"]};j.or[j.S7]=j.or[j.lP]=j.or[j.AU];j.or[j.A5]=j.or[j.yt]=j.or[j.AU];j.or[j.MO]=j.or[j.Yp];j.hR={11:true,12:true,31:true,32:true};j.Er={0:"IE_MQ",1:"FX_MQ",2:"IE_MS",3:"FX_MS"};j.LOAD_ALWAYS=1;j.LOAD_AUTO=0;var
fc=null;var
bb=null;j.Yz=["ie8up",j.MO,"ie7up",j.Yp,"ie6up",j.Tv,"ffox3",j.S7,"ffox2",j.lP,"ffox15",j.AU,"safari2",j.WW,"opera85",j.rM,"geckook",j.yt,"nav6up",j.A5];e.init=function(h){for(var
zb=0;zb<j.Yz.length;zb=zb+2)if(h[j.Yz[zb]]){this.n8=j.Yz[zb+1];break;}if(this.n8==null)this.n8=j.H_;for(var
zb=0;zb<j.or[this.n8].length;zb++)this[j.or[this.n8][zb]]=true;this.N0=[];this.lI={};};e.destroy=function(){for(var
D=0;D<this.N0.length;D++){var
S=this.N0[D];for(var x in S)delete S[x];}delete this.N0;delete this.lI;delete this.sQ;};e.getTypes=function(){return j.or[this.n8];};e.HG=function(){if(this.sQ)return;this.sQ=new
jsx3.util.JobManager();var
nb=this.sQ;var
Eb=j.INCLUDES;var
pb=this;var
Q=j.SYSTEM_SCRIPTS;var
u=new
Qb("jsx.prog1",function(){pb.e4(1,Q.length);});nb.addJob(u);var
vb=null;for(var
v=0;v<Q.length;v++){var
A=j.Q7(jsx3.SYSTEM_SCRIPTS+"/"+this.resolvePath(Q[v]));var
bc=new
j.JsJob("jsxjs"+v,A);bc.A8("finish",this,"jD");nb.addJob(bc,vb);vb=bc.getId();}nb.addJob(new
Qb("jsx.js"),vb?vb:null);nb.addJob(new
Qb("jsx.gui.xsl"),"jsx.js");var
tb=["jsx3.xml.Document","jsx3.app.Settings","jsx3.util.Logger.AlertHandler","jsx3.util.Locale","jsx3.html.Selection","jsx3.util.EventDispatcher","jsx3.app.Server","jsx3.net.URI","jsx3.lang.System"];for(var
v=0;v<tb.length;v++)nb.addJob(new
j.ClassJob(tb[v]));var
yc=new
j.XmlJob("logger.config",jsx3.getEnv("jsx_logger_config")||"jsx:/../logger.xml");nb.addJob(yc,"jsx3.xml.Document");var
Cb=new
Qb("logger.init",function(){var
K=yc.getDocument();jsx3.util.Logger.Manager.getManager().initialize(K);bb=jsx3.util.Logger;fc=jsx3.util.Logger.getLogger("ClassLoader");});nb.addJob(Cb,yc.getId(),"jsx3.util.Logger.AlertHandler");var
qb=new
Qb("jsx.edmix",function(){jsx3.util.EventDispatcher.jsxclass.mixin(pb);jsx3.util.EventDispatcher.jsxclass.mixin(pb.sQ);pb.sQ.subscribe("*",pb,function(d){this.publish(d);});});nb.addJob(qb,"jsx3.util.EventDispatcher");var
dc=new
Qb("jsx.html.mode",function(){pb[j.Er[jsx3.html.getMode()]]=true;});nb.addJob(dc,"jsx3.html.Selection");var
jb=new
Qb("jsx.css.request",function(){var
lb=[];for(var
v=0;v<Eb.length;v++){var
Hc=Eb[v];if(Hc.type=="css"&&pb.Q6(Hc.browser)){var
A=j.Q7("JSX"+"/"+pb.resolvePath(Hc.src));var
bc=new
j.CssJob(Hc.id,A);lb[lb.length]=bc.getId();this.getManager().addJob(bc);}}if(lb.length>0){nb.addJob(new
Qb("jsx.css"),lb);nb.addPrereq("jsx","jsx.css");}});nb.addJob(jb,"jsx.html.mode");var
Ab=new
Qb("jsx.jss.request",function(){var
B=[];for(var
v=0;v<Eb.length;v++){var
S=Eb[v];if(S.type=="ljss"&&jsx3.app.PropsBundle){var
A=j.Q7("JSX"+"/"+pb.resolvePath(S.src));var
bc=new
j.PropsBundleJob(A,jsx3.System.LJSS,jsx3.getSystemCache());B[B.length]=bc.getId();nb.addJob(bc);}}if(B.length>0){nb.addJob(new
Qb("jsx.xml"),B);nb.addPrereq("jsx","jsx.xml");}});nb.addJob(Ab,"jsx3.lang.System");var
G=function(f){if(jsx3.xml&&jsx3.xml.Cacheable){var
lc=jsx3.Class.forName(f.name);if(jsx3.xml.Cacheable.jsxclass.isAssignableFrom(lc)){var
tc=lc.getConstructor().DEFAULTXSLURL;if(tc){var
bc=new
j.XmlJob(tc,tc,jsx3.getSharedCache(),tc,jsx3.xml.XslDocument.jsxclass);nb.addJob(bc);nb.addPrereq("jsx.gui.xsl",bc.getId());}}}};this.A8("class",G);nb.addJob(new
Qb("jsx.gui.xsldn",function(){pb.Ay("class",G);}),"jsx.js");nb.addJob(new
Qb("jsx"),"jsx.js","jsx.xsl",jb.getId(),Ab.getId());nb.addJob(new
Qb("jsx.startup",function(){jsx3.startup();}),"jsx");for(var
v=0;v<this.N0.length;v++)this.AJ(this.N0[v]);window.setTimeout(function(){nb.start();},0);};e.mG=function(d){for(var
jb=this.N0.length-1;jb>=0;jb--)if(this.N0[jb]==d){this.N0.splice(jb,1);break;}};e.e4=function(i,m){for(var
Bb=0;Bb<this.N0.length;Bb++){var
Db=this.N0[Bb].M6;Db.updateStage(i,m);}};e.jD=function(h){for(var
kb=0;kb<this.N0.length;kb++)this.N0[kb].M6.YU(false);};e.PK=function(){return this.kT||j.hR[this.n8];};e.passesLoad=function(r){return r===true||r==1;};e.Q6=function(l){if(l==null)return true;if(this[l])return true;var
yb=j.or[this.n8].join("|");var
K=new
RegExp("\\b("+yb+")\\b");return K.test(l);};e.isActive=function(){return this.sQ.getWaitCt()>0;};e.addJob=function(d,q){return this.sQ.addJob.apply(this.sQ,arguments);};e.loadResource=function(a,h,b,f){var
yb=null;if(b=="script"){yb=new
j.JsJob(h,a);}else if(b=="css"){yb=new
j.CssJob(h,a);}else throw new
jsx3.IllegalArgumentException("strType",b);this.sQ.addJob(yb);if(f)this.sQ.addJob(f,yb.getId());};e.Iv=function(){if(this.xH==null)this.xH=[[j.Q7(jsx3.SYSTEM_SCRIPTS+"/"),/^jsx3\.(gui|util|app|xml|net)\.[\w\.]+$/]];return this.xH;};e.o0=function(f,l){l=l.replace(/\./g,"\\.").replace(/\*\*/g,"[\\w\\.]*").replace(/\*/g,"\\w*");this.Iv().push([f,new
RegExp("^"+l+"$")]);};e.xg=function(p){var
yb=p.getSettings();var
Mb=yb.get("classpath");if(Mb){var
P=Mb.split(",");for(var
Ec=0;Ec<P.length;Ec++){var
Cc=P[Ec].split(":");this.o0(p.resolveURI(Cc[0]).toString(),Cc[1]);}}};e.sp=function(s){var
kc=s.getName();this.T3({subject:"class",name:kc});if(this.publish)this.publish({subject:"class",name:kc});};e.kd=function(g){};e.FN=function(o,c){if(c==null)c=1000;var
sb="[TIBCO General Interface\u2122] "+o;window.status=sb;if(jsx3._jsxp1!=null)window.clearTimeout(jsx3._jsxp1);jsx3._jsxp1=window.setTimeout(function(){jsx3._jsxp1=null;if(window.status==sb)window.status="";},c);};e.loadClass=function(f){this.FN("Loading: "+f+" ...");var
tb=f.replace(/\./g,"/")+".js";var
F=new
jsx3.net.Request();this.Iv();for(var
hc=0;hc<this.xH.length;hc++){var
J=this.xH[hc][1];if(J.test(f)){var
bc=this.xH[hc][0]+tb;var
E=false;try{E=this.loadJSFileSync(bc);}catch(Kc){var
v=jsx3.NativeError.wrap(Kc);throw new
jsx3.Exception(jsx3._msg("boot.class_ex",f,v),v);}if(E){var
Rb=jsx3.Class.forName(f);if(Rb==null)throw new
jsx3.Exception(jsx3._msg("boot.class_undef",bc,f));return Rb;}}}throw new
jsx3.Exception(jsx3._msg("boot.class_err",f));};e.loadJSFileSync=function(o){var
Mb=new
jsx3.net.Request();Mb.open("GET",o,false);Mb.send();if(Mb.getStatus()==200){var
rb=Mb.getResponseText();jsx3.eval(rb);return true;}return false;};e.resolvePath=function(l){return l.replace(/@path@/g,j.TH[this.n8]);};j.Q7=function(q){var
Mb=null;if(q.charAt(0)=="/"||q.match(/^\w+:\/\//)){Mb=q.toString();}else if(q.substring(0,4)=="JSX/"){Mb=jsx3.getEnv("jsxabspath")+q;}else Mb=jsx3.getEnv("jsxhomepath")+q;return Mb;};j.Y9=0;e.loadApp=function(f,a,n){f=f.replace(/%([0-9a-fA-F]{2})/g,function(r,d){return String.fromCharCode(parseInt(d,16));});if(f.charAt(f.length-1)=="/")f=f.substring(0,f.length-1);var
E=f.indexOf("JSXAPPS"+"/");var
eb=E>=0?f.substring(0,E):"";if(!jsx3.getEnv("jsxmanualhome"))jsx3.setEnv("jsxhomepath",eb);jsx3.setEnv("jsxscriptapppath",eb);var
L={h1:f,oG:a,TC:false,BB:false,Bu:n,_serial:j.Y9++};var
F=n["jsxapploader"]!=null?n["jsxapploader"]:this.N0.length>0?1:0;var
Zb=L.M6=new
j.NJ(this,F,a);if(this.PK()){window.setTimeout(function(){Zb.Yu();},0);}else window.setTimeout(function(){Zb.Z7();},0);this.N0.push(L);if(this.sQ)this.AJ(L);};e.AJ=function(n){var
Nc=n.h1;var
Pb="app."+n._serial;var
M=this.sQ;var
Bc=new
j.XmlJob(Pb+".config",Nc+"/config.xml");var
tc=this;var
cc=new
Qb(Pb+".queue",function(){tc.C3(Bc.getDocument(),n);});M.addJob(Bc,"jsx3.xml.Document");M.addJob(cc,"jsx3.app.Server",Bc.getId());};e.C3=function(r,c){var
T=this.sQ;var
Dc=null;T.pause();if(r.hasError())fc.fatal(jsx3._msg("boot.app_cfgerr",r.getSourceURL(),r.getError()));var
Mb=c.p8=new
jsx3.app.Settings(r);c.Bu.jsxsettings=Mb;try{Dc=c.mA=new
jsx3.app.Server(c.h1,c.oG,false,c.Bu);delete c.oG;}catch(Kc){var
Ub=jsx3.NativeError.wrap(Kc);fc.fatal(jsx3._msg("boot.app_insterr",c.h1,Ub),Ub);return;}var
Gc=c.M6;var
G="app."+c._serial;this.xg(Dc);var
Cb=["jsx.js","logger.init","jsx.xml"];var
vb=Mb.get("addins");if(vb)for(var
Ib=0;Ib<vb.length;Ib++){var
Fb=vb[Ib];this.p9(Fb);Cb.push("addin."+Fb+".js","addin."+Fb+".jss");}var
Z=new
Qb(G+".prog");T.addJob(Z,Cb);var
xb=Mb.get("includes");if(xb){var
wc=0;var
v=[],y=[],Y=Z.getId();for(var
xc=0;xc<xb.length;xc++){var
ob=xb[xc];if(this.passesLoad(ob.onLoad||ob.load)&&this.Q6(ob.browser)){var
Sb=Dc.resolveURI(ob.src);var
ec=G+"."+xc+"."+(ob.id||ob.src);if(ob.type=="css"){var
Db=new
j.CssJob(ec,Sb);T.addJob(Db);v[v.length]=Db.getId();}else if(ob.type=="script"){var
Db=new
j.JsJob(ec,Sb);Db.A8("finish",Gc,"YU");T.addJob(Db,Y);Y=Db.getId();wc++;}else if(ob.type=="xml"||ob.type=="xsl"){var
Db=new
j.XmlJob(ec,Sb,Dc.getCache(),ob.id||ob.src);T.addJob(Db);y[y.length]=Db.getId();}else if(ob.type=="jss"){var
Db=new
j.JssJob(ec,Sb,Dc.getProperties(),Dc.getCache(),ob.id||ob.src);T.addJob(Db);y[y.length]=Db.getId();}else if(ob.type=="ljss"){var
Db=new
j.PropsBundleJob(Sb,Dc.LJSS,Dc.getCache(),Dc.getLocale());T.addJob(Db);y[y.length]=Db.getId();}}}Z.run=function(){Gc.updateStage(3,wc);};if(v.length>0)T.addJob(new
Qb(G+".css"),v);if(y.length>0)T.addJob(new
Qb(G+".xml"),y);if(Y)T.addJob(new
Qb(G+".js"),Y);}var
Lb=Mb.get("objectseturl");var
Tb=null;if(Lb){Tb=new
j.XmlJob(G+".comp",c.mA.resolveURI(Lb));T.addJob(Tb);}var
t=new
Qb(G+".prog1",function(){Gc.updateStage(4,1);return 2;});T.addJob(t,"jsx",G+".css",G+".xml",G+".js");var
tc=this;T.addJob(new
Qb(G+".progx",function(){Gc.wu();tc.mG(c);}),t.getId());var
u=new
Qb(G+".paint");if(Tb!=null){u.run=function(){c.mA.paint(Tb.getDocument());};T.addJob(u,Tb.getId(),t.getId());}else{u.run=function(){c.mA.paint();};T.addJob(u,t.getId());}T.start();};e.S6=function(){if(!this.kT){this.kT=true;for(var
Fc=0;Fc<this.N0.length;Fc++)this.N0[Fc].M6.Yu();this.HG();}};e.loadAddin=function(h){var
qb=h.getKey();if(!this.lI[qb]){this.lI[qb]={};this.sQ.pause();this.sQ.addJob(new
Qb("addin."+qb+".x"));this.HA(qb,"addin."+qb+".x");this.nY(h,null);}};e.p9=function(d){var
Xb="addin."+d;if(this.lI[d]){}else{this.lI[d]={};var
B=new
j.XmlJob(Xb+".config",jsx3.System.addinKeyToPath(d)+"/config.xml");var
Y=this;var
Mc=new
Qb(Xb+".load",function(){Y.nY(B.getDocument(),d);});this.sQ.addJob(B,"jsx3.xml.Document");this.sQ.addJob(Mc,B.getId(),"jsx3.lang.System");this.HA(d,Mc.getId());}};e.HA=function(q,b){var
oc="addin."+q;var
lb=this.sQ.addJob(new
Qb(oc+".js"),b);var
pb=this.sQ.addJob(new
Qb(oc+".css"),b);var
Fc=this.sQ.addJob(new
Qb(oc+".jss"),b);var
cc=this.sQ.addJob(new
Qb(oc),lb.getId(),pb.getId(),Fc.getId());};e.nY=function(f,b){var
Cc=null,Fc=null;if(f instanceof jsx3.app.AddIn){Cc=f;Fc=Cc.getSettings();b=Cc.getKey();}else{if(f.hasError()){fc.fatal(jsx3._msg("boot.add_cfgerr",f.getSourceURL(),f.getError()));return;}Fc=new
jsx3.app.Settings(f);Cc=this.lI[b].Wy=new
jsx3.app.AddIn(b,Fc);}var
jc="addin."+b;var
P=this.sQ;var
_b=Fc.get("addin");if(_b)jsx3.System.registerAddin(_b,Cc);this.xg(Cc);P.pause();var
mb=Fc.get("includes");if(mb!=null){var
cb=["jsx.js","logger.init","jsx.xml"];for(var
O=0;O<mb.length;O++){var
lc=mb[O];var
Ec=jc+"."+O+"."+(lc.id||lc.src);if(this.passesLoad(lc.onLoad||lc.load)&&this.Q6(lc.browser)){var
Vb=Cc.resolveURI(lc.src).toString();if(lc.type=="script"){var
Dc=P.addJob(new
j.JsJob(Ec,Vb),cb);Dc.A8("finish",this,"jD");cb=Dc.getId();}else if(lc.type=="css"){var
Dc=P.addJob(new
j.CssJob(Ec,Vb));P.addPrereq(jc+".css",Dc.getId());}else if(lc.type=="jss"){var
Dc=P.addJob(new
j.JssJob(Ec,Vb,jsx3.System.JSS,jsx3.getSystemCache(),lc.id||Vb));P.addPrereq(jc+".jss",Dc.getId());}}}if(cb)P.addPrereq(jc+".js",cb);}P.start();};};Jc(jsx3.lang.ClassLoader,jsx3.lang.ClassLoader.prototype);jsx3.lang.ClassLoader.NJ=function(l,d,p){this.BX=l;this.n8=d;this.oG=p;this.I3=0;this.Qy=0;this.At=1;};var
ac=function(j,s){j.vC=["Initializing...","Loading system...","Loading addins...","Loading application...","Painting application..."];j.TL=[[0,0.1,0.6,0.8,0.97,1,1],[0,0,0,0,0.95,1]];j.LI="Waiting for system";j.SN=["&#160;.","&#160;&#160;.","&#160;&#160;&#160;."];j.i9=0;j.sC=1;j.K4=function(e){if(j.y9==null){j.y9=e.BX.MOZ||e.BX.KON;if(!j.y9)try{var
Cb='<input type="text" id="_jsx3_progress_test" style="position:absolute;top:0px;left:-120px;width:100px;height:30px;padding:8px;margin:0px;"/>';e.oG.insertAdjacentHTML("beforeEnd",Cb);var
Gc=e.oG.ownerDocument.getElementById("_jsx3_progress_test");j.y9=Gc.offsetHeight!=30;Gc.parentNode.removeChild(Gc);}catch(Kc){window.alert(Kc.description);}}return j.y9;};s.Yu=function(){var
sb=this.oG.offsetWidth;var
Ab=this.oG.offsetHeight;var
hb=j.K4(this);this.Y5=true;var
R,uc;if(this.n8==j.i9){var
u=222-(hb?4:0);var
Hb=62-(hb?4:0);var
Hc=17-(hb?2:0);var
Db=Hc-(hb?0:1);var
J=Math.max(0,Math.round((Ab-Hb)/3));var
ub=Math.max(0,Math.round((sb-u)/2));R='<div style="position:absolute;top:'+J+"px;left:"+ub+"px;font-family:Arial,sans-serif;width:"+u+"px;"+'border:1px solid #666677;padding:2px;background-color:#BBBBCC;">'+'<div style="height:'+Hb+'px;border:1px solid #8899AA;padding:0px;background-color:#EEEEEE;">'+'<div style="padding: 4px;">'+'<div style="font-size:10px;">Powered by</div>'+'<div style="font-size:16px;">TIBCO&#160;<span style="font-weight:bold;">General&#160;Interface&#8482;</span></div>'+"</div>"+'<div style="position:absolute;top:'+(Hb-Hc+(hb?2:1))+"px;height:"+Hc+"px;width:"+(u-(hb?2:8))+'px;background-color:#DDE0EE;border-top:1px solid #8899AA;">'+'<div style="height:'+Db+'px;position:absolute;background-color:#BBCCEE;width:0px;overflow:hidden;">&#160;</div>'+'<div style="height:'+Db+'px;font-family:Verdana,sans-serif;position:absolute;font-size:10px;color:#000033;padding:1px 4px 2px 4px;">'+j.vC[0]+"</div>"+"</div>"+"</div>"+"</div>";uc="#9898a5";}else{var
u=165-(hb?4:0);var
Hb=52-(hb?4:0);var
Hc=16-(hb?2:0);var
Db=Hc-(hb?0:2);var
J=Math.max(0,Math.round((Ab-Hb)/3));var
ub=Math.max(0,Math.round((sb-u)/2));R='<div><div style="position:absolute;top:'+J+"px;left:"+ub+"px;font-family:Arial,sans-serif;width:"+u+"px;height:"+Hb+'px;padding:0px;">'+'<div style="padding: 6px;">'+'<div style="font-size:9px;">Powered by</div>'+'<div style="font-size:12px;">TIBCO&#160;<span style="font-weight:bold;">General&#160;Interface&#8482;</span></div>'+"</div>"+'<div style="position:absolute;top:'+(Hb-Hc+(hb?2:1))+"px;height:"+Hc+"px;width:"+(u-(hb?2:0))+'px;background-color:#EEF5FF;border:1px solid #88AACC;">'+'<div style="height:'+Db+'px;position:absolute;background-color:#BBDDFF;width:0px;overflow:hidden;">&#160;</div>'+'<div style="height:'+Db+'px;text-align:center;font-family:Verdana,sans-serif;z-index:1;position:absolute;font-size:9px;color:#556677;padding:1px 4px 2px 4px;">&#160;</div>'+"</div>"+"</div></div>";uc="#FFFFFF";}this.oG.innerHTML=R;this.oG.style.backgroundColor=uc;};s.Z7=function(){var
nc=this.oG.offsetWidth;var
Kc=this.oG.offsetHeight;var
ab=j.K4(this);this.Y5=true;var
cc=222-(ab?4:0);var
nb=136-(ab?4:0);var
Dc=17-(ab?2:0);var
T=Dc-(ab?0:1);var
ec=Math.max(0,Math.round((Kc-nb)/3));var
O=Math.max(0,Math.round((nc-cc)/2));var
ob="S6";var
P='<div style="position:absolute;top:'+ec+"px;left:"+O+"px;font-family:Arial,sans-serif;width:"+cc+"px;"+'border:1px solid #666677;padding:2px;background-color:#BBBBCC;">'+'<div style="height:'+nb+'px;border:1px solid #8899AA;padding:0px;background-color:#EEEEEE;">'+'<div style="padding: 4px;">'+'<div style="font-size:10px;">Powered by</div>'+'<div style="font-size:16px;">TIBCO&#160;<span style="font-weight:bold;">General&#160;Interface&#8482;</span></div>'+'<div style="padding:6px 0px 0px 0px;font-size:10px;font-family:Verdana,sans-serif;">This application has been optimized for <b>Microsoft Internet Explorer 6/7</b> and <b>Mozilla Firefox 1.5/2</b> Results in other browsers may be unpredictable.'+'<div style="color:#000033;padding:8px 0px 0px 0px;margin:0px 0px 0px -2px;">'+'<span style="font-size:8px;">&gt; </span><a style="color:#000033;" href="http://power.tibco.com/gi/builderlink/sysreqs34/" target="_blank">See full system requirements</a>'+'<div style="padding:2px 0px 0px 0px;"><span style="font-size:8px;">&gt; </span><span id="jsxforcestart_span" tabindex="1" style="cursor:pointer;text-decoration:underline;" '+'onclick="jsx3.CLASS_LOADER.'+ob+'();" onkeydown="if (event.keyCode == 13) this.onclick();">Continue anyway</span></div>'+"</div>"+"</div>"+"</div>"+"</div>"+"</div>";this.oG.innerHTML=P;this.oG.style.backgroundColor="#9898a5";window.setTimeout(function(){document.getElementById("jsxforcestart_span").focus();},0);};s.updateStage=function(l,p){this.I3=l;this.At=p;this.Qy=0;this.BA(true);};s.YU=function(){this.Qy++;this.BA(false);if(this.BX.IE&&(this.Qy%20==0||this.At<5||this.Qy==this.At)){var
Y=this.BX.sQ;if(Y.TN){Y.pause();window.setTimeout(function(){Y.start();},0);}}};s.BA=function(h){if(!this.Y5)return;var
bb=j.TL[this.n8];var
ib=this.At==0?1:Math.max(0,Math.min(1,this.Qy/this.At));var
hb=bb[this.I3]+(bb[this.I3+1]-bb[this.I3])*ib;hb=Math.min(hb,1);try{if(h&&this.n8==j.i9)this.QA(j.vC[this.I3]);var
eb=this.oG.childNodes[0].childNodes[0].childNodes[1].childNodes[0];var
Wb=Math.round(eb.parentNode.offsetWidth*hb);if(this.n8==j.sC)if(Wb>0){this.QA(j.vC[4]);}else if(this.YL==null){this.YL=0;this.QA(j.LI+j.SN[0]);this.QJ=(new
Date()).getTime();}else{var
fb=(new
Date()).getTime();if(fb-this.QJ>500){this.YL++;this.QA(j.LI+j.SN[this.YL%j.SN.length]);this.QJ=fb;}}eb.style.width=Wb+"px";}catch(Kc){}};s.QA=function(n){try{this.oG.childNodes[0].childNodes[0].childNodes[1].childNodes[1].innerHTML=n;}catch(Kc){}};s.wu=function(q){delete this.oG;};};ac(jsx3.lang.ClassLoader.NJ,jsx3.lang.ClassLoader.NJ.prototype);jsx3.CLASS_LOADER=new
jsx3.lang.ClassLoader(new
ic());}var
W=function(b){var
M={};var
K=b.indexOf("?");if(K>=0){b=b.substring(K+1);var
gb=b.split("&");for(var
lc=0;lc<gb.length;lc++){var
Nc=gb[lc].indexOf("=");if(Nc>=0){M[gb[lc].substring(0,Nc)]=gb[lc].substring(Nc+1);}else M[gb[lc]]=true;}}return M;};var
_={id:true,space:true,type:true,charset:true,defer:true,src:true,language:true};var
Ic=function(b){var
tc=W(b.src);var
Pb=b.attributes;for(var
qc=0;qc<Pb.length;qc++)if(!_[Pb[qc].nodeName])tc[Pb[qc].nodeName]=Pb[qc].nodeValue;for(var t in tc)if(t.indexOf("jsx")==0&&t.indexOf("jsxapp")!=0){jsx3.setEnv(t,tc[t]);delete tc[t];}var
lc=b.getAttribute("src");var
kc=lc.substring(0,lc.indexOf(jsx3.MAIN_SCRIPT));kc=kc.replace(/\/\.\//g,"/").replace(/^\.\//,"");jsx3.setEnv("jsxabspath",kc);if(!tc["jsxappempty"]){var
Vb=tc["jsxapppath"];if(Vb){b.setAttribute("jsxloaded","1");jsx3.CLASS_LOADER.loadApp(Vb,b.parentNode,tc);return true;}else window.alert("Deployment parameter 'jsxapppath' is required.");}return false;};var
wb=function(){var
mb=document.getElementsByTagName("script");var
Eb=false;for(var
Zb=0;Zb<mb.length;Zb++){var
Cc=mb[Zb];var
B=Cc.getAttribute("src");if(!Cc.getAttribute("jsxloaded")&&B&&B.indexOf(jsx3.MAIN_SCRIPT)>=0)Eb=Ic(Cc)||Eb;}if(Eb&&jsx3.CLASS_LOADER.PK())jsx3.CLASS_LOADER.HG();};wb();};window.jsx_main();
