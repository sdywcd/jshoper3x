//
//  MainViewController.h
//  01 HomeWork
//
//  Created by wei.chen on 14-1-8.
//  Copyright (c) 2014年 www.iphonetrain.com 无限互联3G学院. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MainViewController : UITableViewController<UITextFieldDelegate> {
    NSArray *_data;
}

@property(nonatomic,retain)NSArray *filteData;

@end
