/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Axis");jsx3.Class.defineClass("jsx3.chart.CategoryAxis",jsx3.chart.Axis,null,function(c,p){c.TICKS_ALIGNED="aligned";c.TICKS_BETWEEN="between";c.MAX_TICKS=200;c.TQ={aligned:1,between:1};p.init=function(i,r,q){this.jsxsuper(i,r,q);this.tickAlignment="between";this.categoryField=null;this.paddingLow=null;this.paddingHigh=null;this.tm("MB",0);this.tm("WA",0);};p.getTickAlignment=function(){return this.tickAlignment;};p.setTickAlignment=function(l){if(c.TQ[l]){this.tickAlignment=l;}else throw new
jsx3.IllegalArgumentException("tickAlignment",l);};p.getCategoryField=function(){return this.categoryField;};p.setCategoryField=function(m){this.categoryField=m;};p.getPaddingLow=function(){return this.paddingLow!=null?this.paddingLow:0;};p.setPaddingLow=function(h){this.paddingLow=h;};p.getPaddingHigh=function(){return this.paddingHigh!=null?this.paddingHigh:0;};p.setPaddingHigh=function(r){this.paddingHigh=r;};p.ve=function(){this.lk("Xc");var
db=this.getChart();if(db==null){this.tm("MB",0);this.tm("WA",0);}else{var
tc=db.Xi(this,true);var
ic=db.bi();this.tm("WA",tc.length);this.tm("MB",ic!=null?ic.length:0);}};p.yf=function(){var
nc=this.pk("Xc");if(nc!=null)return nc;var
B=this.pk("MB");nc=[];if(B<1)return nc;var
gb=this.getPaddingLow();var
Vb=this.getPaddingHigh();var
x=this.tickAlignment=="between"?B+1:B;var
Lb=x-1;var
fc=Lb+gb+Vb;var
pc=this.length/fc;var
C=gb*pc;for(var
Qb=0;Qb<x&&Qb<c.MAX_TICKS;Qb++)nc.push(Math.round(C+Qb*pc));this.tm("Xc",nc);return nc;};p.Pi=function(){var
uc=this.pk("MB");if(this.tickAlignment=="between"){var
Ac=this.yf();var
Xb=[];for(var
vb=0;vb<uc;vb++)Xb[vb]=Math.round((Ac[vb]+Ac[vb+1])/2);return Xb;}else return this.yf();};p.af=function(b){var
Pb=b;var
z=this.getChart();if(this.categoryField&&z!=null){var
ac=z.bi();if(ac!=null){var
gb=ac[b];if(gb!=null)Pb=gb.getAttribute([this.categoryField]);}}return Pb;};p.Kk=function(){return false;};p.getRangeForCategory=function(j){var
_=this.yf();if(this.tickAlignment=="between"){if(j<0||j>=_.length-1)return null;else return [_[j],_[j+1]];}else{if(j<0||j>=_.length||_.length<2)return null;var
Xb=j==0?_[1]-_[0]:_[j]-_[j-1];return [Math.round(_[j]-Xb/2),Math.round(_[j]+Xb/2)];}};p.getPointForCategory=function(n){var
Ab=this.yf();if(this.tickAlignment=="between"){if(n<0||n>=Ab.length-1)return null;else return Math.round((Ab[n]+Ab[n+1])/2);}else return Ab[n];};p.toString=function(){return "[CategoryAxis '"+this.getName()+"' hor:"+this.horizontal+" pri:"+this.primary+"]";};c.getVersion=function(){return jsx3.chart.sj;};});
