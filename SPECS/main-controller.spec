Name: main-controller
Version: None
Release: 1%{?dist}
Group: Application/Web
License: Internal BBC use only
Summary: main-controller
Source0: main-controller_ssl_termination.conf
Source1: main-controller_http_termination.conf
Source2: bbc-flume.conf
Source3: bake-scripts.tar.gz
Source4: ROOT.war
Requires: logrotate-config-tomcat, mod_ssl, gc-log-config-tomcat, cosmos-ca-chains, java-1.7.0-openjdk-devel, cosmos-ca-tools, tomcat6, flume-ng-agent, flume-ng
BuildRoot: %(mktemp -ud %{_tmppath}/%{name}-%{version}-%{release}-XXXXXX)
BuildArch: noarch
BuildRequires: python-setuptools, redhat-rpm-config

%description
main-controller built by the Magic Build Tool

%prep
%setup -T -c mbt

%build


%install
mkdir -p %{buildroot}/etc/httpd/conf.d/
cp %{SOURCE0} %{buildroot}/etc/httpd/conf.d/main-controller_ssl_termination.conf
mkdir -p %{buildroot}/etc/httpd/conf.d/
cp %{SOURCE1} %{buildroot}/etc/httpd/conf.d/main-controller_http_termination.conf
mkdir -p %{buildroot}/etc/flume-ng/conf/
cp %{SOURCE2} %{buildroot}/etc/flume-ng/conf/bbc-flume.conf
mkdir -p %{buildroot}%{_sysconfdir}/bake-scripts/main-controller
tar -C %{buildroot}%{_sysconfdir}/bake-scripts/main-controller -xzf %{SOURCE3}
mkdir -p %{buildroot}/usr/share/tomcat6/webapps/
unzip -d %{buildroot}/usr/share/tomcat6/webapps/ROOT %{SOURCE4}

%pre


%preun


%post


%postun


%clean
rm -rf %{buildroot}

%files
%defattr(644, root, root, 755)
/etc/httpd/conf.d/main-controller_ssl_termination.conf
%defattr(644, root, root, 755)
/etc/httpd/conf.d/main-controller_http_termination.conf
%defattr(644, root, root, 755)
/etc/flume-ng/conf/bbc-flume.conf
%defattr(-, root, root, 755)
/etc/bake-scripts/main-controller
%defattr(644, root, root, 755)
/usr/share/tomcat6/webapps/ROOT


