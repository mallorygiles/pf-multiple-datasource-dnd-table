This is a sample project where I would like to be able to drag and drop rows between multiple tables. The issue is that
if I use multiple <p:droppable> for the same component, only the last one is used. Therefore, if you try to drag from
table whose datasource was given in the first <p:droppable>, it will actually use the datasource of the last one. For
example, for table 2, the droppables are the datasource for table 1 then for table 3. If I attempt to drag from table 1 
to table 2, it will actually take the row from table 3. If there are only 3 columns in table 3 and I attempt to drag the 
4th column from table 1, then I receive a javax.faces.model.NoRowAvailableException.