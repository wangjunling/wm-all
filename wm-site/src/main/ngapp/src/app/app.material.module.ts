/**
 * Created by Administrator on 2017/8/16.
 */
import {NgModule} from '@angular/core';

import {
  MdButtonModule,
  MdCardModule,
  MdMenuModule,
  MdListModule,
  MdToolbarModule,
  MdIconModule,
  MdSidenavModule
} from '@angular/material';


@NgModule({
  exports: [
    MdButtonModule,
    MdCardModule,
    MdMenuModule,
    MdListModule,
    MdToolbarModule,
    MdIconModule,
    MdSidenavModule
  ]
})
export class AppMaterialModule {}
