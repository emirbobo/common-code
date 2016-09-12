package com.worklight.androidgap.plugin.storage;

public class StoragePlugin
  extends DispatchingPlugin
{
  public StoragePlugin()
  {
    addDispatcher(new AllDirtyActionDispatcher());
    addDispatcher(new ChangePasswordActionDispatcher());
    addDispatcher(new CloseDatabaseActionDispatcher());
    addDispatcher(new DestroyDBFileAndKeychainActionDispatcher());
    addDispatcher(new DropTableActionDispatcher());
    addDispatcher(new CountActionDispatcher());
    addDispatcher(new FindActionDispatcher());
    addDispatcher(new FindByIdActionDispatcher());
    addDispatcher(new IsDirtyActionDispatcher());
    addDispatcher(new IsKeyGenRequiredActionDispatcher());
    addDispatcher(new LocalCountActionDispatcher());
    addDispatcher(new MarkCleanActionDispatcher());
    addDispatcher(new ProvisionActionDispatcher());
    addDispatcher(new RemoveActionDispatcher());
    addDispatcher(new ReplaceActionDispatcher());
    addDispatcher(new StoreActionDispatcher());
    addDispatcher(new StoreDPKActionDispatcher());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\StoragePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */