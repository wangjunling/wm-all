import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppMaterialModule} from "./app.material.module";
import "hammerjs";
import {AppComponent} from "./app.component";
import {OverviewComponent} from "./overview/overview.component";
import {ArticleListComponent} from "./article/article-list.component";
import {ArticleService} from "./article/article.service";
import { HttpModule }    from '@angular/http';
@NgModule({
  declarations: [
    AppComponent, OverviewComponent,ArticleListComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule, AppMaterialModule,HttpModule
  ],
  providers: [ArticleService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
