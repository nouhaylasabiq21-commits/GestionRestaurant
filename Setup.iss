[Setup]
AppName=GestionRestaurant
AppVersion=1.0
DefaultDirName={pf}\GestionRestaurant
DefaultGroupName=GestionRestaurant
OutputDir=Output
OutputBaseFilename=GestionRestaurant_Setup
Compression=lzma
SolidCompression=yes

[Files]
Source: "dist\GestionRestaurant.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "dist\lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\GestionRestaurant"; \
  Filename: "javaw.exe"; \
  Parameters: "-jar ""{app}\GestionRestaurant.jar"""; \
  WorkingDir: "{app}"

Name: "{commondesktop}\GestionRestaurant"; \
  Filename: "javaw.exe"; \
  Parameters: "-jar ""{app}\GestionRestaurant.jar"""; \
  WorkingDir: "{app}"

[Run]
Filename: "javaw.exe"; \
Parameters: "-jar ""{app}\GestionRestaurant.jar"""; \
WorkingDir: "{app}"; \
Flags: nowait postinstall skipifsilent
